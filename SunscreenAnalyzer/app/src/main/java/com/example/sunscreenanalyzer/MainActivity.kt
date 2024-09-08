package com.example.sunscreenanalyzer

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import com.example.IngredientNames.*

const val TAG = "MAIN ACTIVITY"

class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        // An item is selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos).
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback.
    }
}


class MainActivity : AppCompatActivity() {

    // initialize all the components in the main activity
    private lateinit var companySpinner : Spinner
    private lateinit var productSpinner : Spinner
    private lateinit var submitButton   : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // organize all products first
        organizeLists()

        // initialize the components in the main activity
        companySpinner = findViewById(R.id.companySpinner)
        productSpinner = findViewById(R.id.productSpinner)
        submitButton   = findViewById(R.id.submitButton)

        // setup the company spinner //
        setupSpinner(companyNames, companySpinner)

        // set up the company spinner listener
        companySpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                // get the item that was selected
                val item = parent?.getItemAtPosition(p2)

                // use the item that was selected to configure the second spinner (product spinner)
                if(item != null){
                    setupSpinner(companyToProductNames[item]!!, productSpinner)
                } else {
                    throw Exception("cannot find company")
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        // set up the button listener
        submitButton.setOnClickListener {
            Log.d(TAG, "Submit button clicked")
            val intent = Intent(this, SunscreenAnalysisActivity::class.java)

            // bundle the information about which product was selected
            val bundle = Bundle()
            bundle.putString("product", productSpinner.selectedItem.toString())
            bundle.putString("company", companySpinner.selectedItem.toString())

            intent.putExtras(bundle)

            // send the intents
            startActivity(intent)
        }



    }

    private fun setupSpinner(stringArray: Array<String>, spinner: Spinner) {
        // Create an ArrayAdapter using the provided string array and a default spinnerlayout
        ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            stringArray
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }


    private fun setupCompanySpinner() {
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter.createFromResource(
            this,
            R.array.companyArray,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            companySpinner.adapter = adapter
        }
    }
}