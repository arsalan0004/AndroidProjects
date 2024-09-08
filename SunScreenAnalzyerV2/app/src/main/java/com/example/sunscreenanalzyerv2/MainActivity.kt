package com.example.sunscreenanalzyerv2

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.sunscreenanalzyerv2.allIngredients

val TAG = "Main Activity"
val MAX_INGREDIENTS = 6


class MainActivity : AppCompatActivity() {

    // current number of ingredients user has added
    var num_ingredients = 1

    // reference to all the ingredient labels
    var addedIngredients = ArrayList<Pair<AutoCompleteTextView, TextView>>()

    // button to add ingredients
    lateinit var addButton : Button
    // button to submit information
    lateinit var submitButton : Button

    // space that ingredient rows will be added
    lateinit var addSpace : LinearLayout

    // first row where ingredients can be added
    lateinit var firstIngredientName : AutoCompleteTextView
    lateinit var firstIngredientIncorp : EditText

    // warning label that notifies user about issues
    lateinit var warningLabel : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // get references to all views
        // ===========================
        // get reference to the first row ingredient

        // get reference to space where new rows can be added
        addSpace = findViewById<LinearLayout>(R.id.layout_list)
        // get reference to button to add rows
        addButton = findViewById<Button>(R.id.add_button)
        // get reference to the submit button
        submitButton = findViewById<Button>(R.id.button_submit)
        // get reference to the first row ingredient
        firstIngredientName = findViewById(R.id.tv_ingredient1)
        firstIngredientIncorp = findViewById(R.id.tv_ing1Incorp)

        // set autocomplete options on first ingredient
        setUpAutoCompleteTV(firstIngredientName)

        // get reference to warning
        warningLabel = findViewById(R.id.tv_warning)

        // make add button clickable
        addButton.setOnClickListener {
            addRow()
        }

        // make submit button clickable
        submitButton.setOnClickListener{
            submitIngredients()
        }


    }

    private fun checkValidIngredient(ingredientName : AutoCompleteTextView): Int {

        var errorCode = 0

        // 1. check if the ingreident is null (ie, nothing was entered)
        if(ingredientName.text.toString() == ""){
            errorCode = 1
        }

        // 2. if name is not in the list of possible ingredients
        else if(ingredientName.text.toString() !in allIngredients){
            errorCode = 10
        }

        return errorCode
    }

    private fun resetMainPageSettings(){

        // reset all the ingredients and incorperations color schemes
        for ((name, incorp) in addedIngredients){
            name.setHintTextColor(0x80808080.toInt())
            name.setTextColor(0xFF000000.toInt())
            incorp.setTextColor(0xFF000000.toInt())
        }

    }

    private fun submitIngredients() {

        // add the first, default, ingredient
        addedIngredients.add(Pair(firstIngredientName, firstIngredientIncorp))

        // reset all warnings from previous iteration
        resetMainPageSettings()

        // check that all ingredients are valid, and that their incorperation is in range (0-100)
        // ======================================================================================

        for ((name, incorp) in addedIngredients){

            var incorpNum = 1000f // set value to fail
            var incorpImpossible = false
            if(incorp.text.toString() != "") {
                 incorpNum= incorp.text.toString().toFloat()
            }

            // 1. check that the name input is valid
            // =====================================
            val errorCode = checkValidIngredient(name)
            if (errorCode == 1){
                // means that the ingredient was not input
                warningLabel.text = "You did not enter a name for one of your ingredients."
                name.setHintTextColor(0xFFFF0000.toInt())
            }

            else if(errorCode == 10){
                // means that the ingredient was not in the proper range
                warningLabel.text = "One of your ingredients is not recognized."
                name.setTextColor(0xFFFF0000.toInt())
            }

            // 2. check that the incorperation value is valid (between 0-100)
            else if(incorpNum > 100 || incorpNum < 0){
                incorpImpossible = true
                warningLabel.text = "One of your ingredients has an impossible % value."
                // make the label red
                incorp.setTextColor(0xFFFF0000.toInt())
            }

            if(errorCode > 0 || incorpImpossible){
                // make text white, with red background
                warningLabel.setBackgroundColor(0xFFFF0000.toInt())
                warningLabel.setTextColor(0xFFFFFFFF.toInt())
                return // exit function without sumitting
            }

        }


        // check if ingredients belong to available set


        // read all the names of ingredients, and prepare to send them to the //
        // activity which will analyze the data
        val intent = Intent(this, SunscreenAnalysisActivity::class.java)
        val bundle = Bundle()

        // add one because of the default ingredient
        bundle.putString("numItems", (addedIngredients.size).toString())

        var currItem : Int = 0
        for((ingredientLabel, ingredientIncorperation) in addedIngredients){

            bundle.putString("ingredient_n $currItem", ingredientLabel.text.toString())
            bundle.putString("ingredient_i $currItem", ingredientIncorperation.text.toString())
            currItem +=1
        }

        intent.putExtras(bundle)

        // send the intents
        startActivity(intent)



    }


    private fun addRow(){
        num_ingredients += 1

        val newRow = layoutInflater.inflate(R.layout.activity_add, null, false)

        // change the recommended name

        // get reference to the ingredient
        val new_ingredientName = newRow.findViewById<AutoCompleteTextView>(R.id.tv_new_ingredient)
        // setup the autocomplete function
        setUpAutoCompleteTV(new_ingredientName)

        // get reference to the incorperation percent
        val new_ingredientIncorp = newRow.findViewById<EditText>(R.id.tv_ingIncorp)

        // add ingredient and its incorperation to the reference list
        addedIngredients.add(Pair(new_ingredientName, new_ingredientIncorp))

        // add to the space
        addSpace.addView(newRow)

        // if maximum ingredients, then get rid of the button!
        if(num_ingredients > MAX_INGREDIENTS){
            addButton.isVisible = false
        }


    }

    private fun setUpAutoCompleteTV(tv: AutoCompleteTextView){
        // setup the hint
        tv.hint = "Enter an ingredient"

        // setup the adapter, with all the hints. hints from com.example.snuscreenAnalyzerv2/IngredientNames.kt
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, allIngredients)
        tv.setAdapter(adapter)
    }

    private fun autoCompleteNameCheck(){
        // check if the names are ingredients we have listed
    }



}