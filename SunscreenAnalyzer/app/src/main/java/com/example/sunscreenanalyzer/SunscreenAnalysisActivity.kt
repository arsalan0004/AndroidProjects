package com.example.sunscreenanalyzer

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Shader
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import java.lang.Math.abs

import com.example.IngredientNames.*
import java.lang.Math.pow

const val MIN_WAVELENGTH = 290
const val MAX_WAVELENGTH = 400
const val LIMIT_LINE_WIDTH = 1f
const val FILM_THICKNESS = (20f/1_000_000f) // 20 micrometers

var activeIngredientsNotProvided = true

val goodAvobenzoneStabilizers = arrayOf(
    "Octocrylene",                        // 3.6% solution stabilizes it 90%
    "4-Methylbenzilidine camphore",       // 5% solution stabilizes it 87%
    "Bemotrizanol",                       // 5% solution stabilizes it 81%
    "Oxybenzone",                         // 5% solution stabilizes it 80%
    "Diethylhexyl syringylidenemalonat" ) // 0.8% solution stabilizes it 73%

val badAvobenzoneStabilizers = arrayOf(
    "Polysilicone 15",                       // 4% stabilizes at 53%
    "Tris citrate",                          // 2% stabilizes at 53%
    "Tetramethylhydroxypiperidinol citrate", // same as tris citrate
    "Butyloctyl salicylate",                 // 5% stabilizes at 50%
    "Polyester 8",                           // 3% stabilizes at 3%
    "Diethylhexyl-2,6-naphthalate")          // 5% stabilize at 47%

class UVCValueFormatter1 : ValueFormatter() {


    override fun getFormattedValue(value: Float): String {
        var result = ""
        when(value){
            290f -> result = "UV-C"
            300f -> result = "UV-B"
            330f -> result = "UV-A1"
            370f -> result = "UV-A2"
            else -> result = ""
        }
        return result

    }
}

class UVCValueFormatter2 : ValueFormatter() {

    fun withinTwo(value: Float, target: Float): Boolean {
        if (abs(value - target) <= 2) {
            return true
        } else {
            return false
        }
    }

    var nextTarget = MIN_WAVELENGTH * 1f
    var printNext = false
    override fun getFormattedValue(value: Float): String {
        var result = ""
        //Log.i(TAG, "value before $value")


        if(printNext == true){
            result = "${value.toInt()}"
            printNext = false
        } else {
            result = ""
            printNext = true
        }


        return result

    }
}

private const val GRAPH_ANIMATION_SPEED = 1000L

class SunscreenAnalysisActivity : AppCompatActivity() {

    // TOODOO: MENTION SYNERY of MEXORYLs

    private val TAG = "SunscreenAnalysisActivity"

    // get reference to the members of this activity
    private lateinit var resultSpectrumChart : LineChart

    private lateinit var ingredients: MutableList<Pair<String, Float>>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sunscreen_analysis)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // create an empty spectrum
        var finalSpectrum = mutableMapOf<String, Float>()

        // populate the spectrum with zeros from min wavelength to max wavelength
        for(wavelength in MIN_WAVELENGTH..MAX_WAVELENGTH step 5){
            finalSpectrum.put(wavelength.toString(), 0.0f)
        }

        // get the name of the product that was selected
        val productName : String? = intent.getStringExtra("product")
        val companyName : String? = intent.getStringExtra("company")

        // if the product was found
        if ((productName != null) && (companyName != null)) {

            // update the title of the page
            val tvTitle : TextView = findViewById(R.id.tvActivityTitle)
            tvTitle.text = "Analysis for $companyName $productName"

            // get products list
            val prodList = companyToProductLists.get(companyName)

            if(prodList == null){
                Log.i(TAG, "ERROR, no product found")
            }

            // get ingredients
            val currIngs : List<Pair<String, Float>>?= prodList?.get(productName)

            if(currIngs == null){
                Log.i(TAG, "ERROR, no ingredients found")
            }

            // load the solar info for each ingredient and add it to the final result
            ingredients = mutableListOf<Pair<String, Float>>() // initialize array of ingredients

            if (currIngs != null) {
                for((name, incorperation) in currIngs){

                    ingredients.add(Pair(name, incorperation))

                    // get the ID for the ingredient
                    val id_ingredientSolarValues = resources.getIdentifier(name, "array", packageName)

                    if(id_ingredientSolarValues == 0){
                        throw Exception("ingredient not found: $name")
                    }

                    // get the solar values for the ingredients
                    val solarValues = resources.getStringArray(id_ingredientSolarValues)

                    //Log.i(TAG, "solar values: $solarValues")

                    // add solar values to the final result spectrum
                    for (item in solarValues) {
                        val parts = item.split(",")
                        if (parts.size== 2) {

                            val key : String = parts[0]
                            val value = parts[1].toFloat() // Handle potential parsing errors

                            //Log.i(TAG, "key: $key, value: $value")

                            if(key == "400"){
                                Log.i(TAG, "before wl: 400, $value, $incorperation")
                                Log.i(TAG, "before swl : 400, ${finalSpectrum["400"]}")
                            }


                            // convert E11 value into absorption value
                            finalSpectrum[key] = finalSpectrum[key]!! + (value * incorperation)

                            if(key == "400"){
                                Log.i(TAG, "wl: 400, $value, $incorperation")
                                Log.i(TAG, "swl : 400, ${finalSpectrum["400"]}")
                            }



                        }
                    }
                }

                // convert absorption value into transmittence value
                for ((wl, a) in finalSpectrum){
                    // reduce path of light. Multiply by 100 to get into units of meters from cm
                    val real_absorbance = a * FILM_THICKNESS * 100

                    val tranmittence = pow(10.0, (-real_absorbance).toDouble())

                    val blockage = 1 - tranmittence

                    finalSpectrum[wl] = blockage.toFloat() * 100
                }

                // get the amount of absorbance for UVA, UVB
                var absA = getAreaUnderGraph(finalSpectrum, 340, 400)
                var absB = getAreaUnderGraph(finalSpectrum, 320, 340)

                absA = absA / (100 * 60)
                absB = absB / (20 * 100)
                // Log.i(TAG, "$absA , $absB : viola, les abs values")

                // update the indicator that says how much UVA/UVB we are blocking
                updateBlockingLabel(absA, absB)
            }
        }
        else {
            throw Exception("No product was selected")
        }


        // check if there was no spectrum generated, which can happen when we are not given the percent
        // of the active ingredients. In that case, we need to tell the user that the product has
        // not been provided with active ingredients
        activeIngredientsNotProvided =  checkActiveIngredientsProvided(finalSpectrum)

        // get reference to the graph
        resultSpectrumChart = findViewById(R.id.resultingSpectrumChart)

        // convert the empty spectrum into a list of entries
        val entries = ArrayList<Entry>()

        for (item in finalSpectrum){
            entries.add(Entry(item.key.toFloat(), item.value))
        }

        // create a dataset to add the entries into
        val dataSet = LineDataSet(entries, "Spectrum Data")

        // set style of the dataset //
        dataSet.color = R.color.black
        dataSet.lineWidth = 4f
        dataSet.setDrawCircles(false)
        dataSet.setDrawValues(false)

        // make the line smooth
        dataSet.mode = LineDataSet.Mode.CUBIC_BEZIER

        // create the lineData object which holds all the data
        val lineData = LineData(dataSet)

        // load the data into the chart
        resultSpectrumChart.data = lineData

        // disable the auto-enabled 2nd y axis on the right
        resultSpectrumChart.axisRight.isEnabled = false
        
        // remove the grid lines from the chart
        resultSpectrumChart.xAxis.setDrawGridLines(false)
        resultSpectrumChart.axisLeft.setDrawGridLines(false)

        // remove the legend
        resultSpectrumChart.legend.isEnabled = false

        // remove the description label from the chart
        resultSpectrumChart.description = null

        // move the x-axis so that it is at the bottom of the chart
        resultSpectrumChart.xAxis.position = XAxis.XAxisPosition.BOTTOM

        // set x axis granularity to each int
        resultSpectrumChart.xAxis.granularity = 1f
        resultSpectrumChart.xAxis.setLabelCount(21, true)
        
        // set the y axis minimum value to 0
        resultSpectrumChart.axisLeft.setAxisMinValue(0f)

        // format X axis so that we don't show values, but instead, labels like "UV-A, UV-B etc"
        resultSpectrumChart.xAxis.valueFormatter = UVCValueFormatter2()

        // add limit lines to the graph to delimit the UV regions
        val limitLine1 = LimitLine(290f, "UV-C")
        val limitLine2 = LimitLine(320f, "UV-B")
        val limitLine3 = LimitLine(340f, "UV-A")
        val limitLine4 = LimitLine(400f, "Visible Light")


        limitLine1.lineWidth = LIMIT_LINE_WIDTH
        limitLine2.lineWidth = LIMIT_LINE_WIDTH
        limitLine3.lineWidth = LIMIT_LINE_WIDTH
        limitLine4.lineWidth = LIMIT_LINE_WIDTH

        limitLine1.lineColor = R.color.black
        limitLine2.lineColor = R.color.black
        limitLine3.lineColor = R.color.black
        limitLine4.lineColor = R.color.black

        resultSpectrumChart.xAxis.addLimitLine(limitLine1)
        resultSpectrumChart.xAxis.addLimitLine(limitLine2)
        resultSpectrumChart.xAxis.addLimitLine(limitLine3)
        resultSpectrumChart.xAxis.addLimitLine(limitLine4)

        // give the line a color based on its value
        val paint: Paint = resultSpectrumChart.getRenderer().getPaintRender()
        paint.setShader(
            LinearGradient(
                0f,
                resultSpectrumChart.contentRect.top,
                0f,
                resultSpectrumChart.contentRect.bottom + 400f,
                Color.GREEN,
                Color.RED,
                Shader.TileMode.REPEAT
            )
        )

        // force graph to show 1.0f no matter what values are in the graph
        resultSpectrumChart.axisLeft.setAxisMaximum(100.1f)

        // refresh the chart to display the data
        resultSpectrumChart.invalidate()


        //                            //
        // DONE WITH FORMATTING CHART //
        //                            //

        // update the ingredients display
        updateIngredients(ingredients)

        // update the cautions //
        // 1. get reference to the warning textView
        val tvIngredientWarnings : TextView = findViewById(R.id.tvIngredientWarnings)

        // 2. check if active ingredients not available
        if(activeIngredientsNotProvided == true){
            tvIngredientWarnings.text =
                    "• Unfortunatly, the percent incorperation of the active ingredients " +
                    "were not provided by the manufacturer. Therefore, there is no way to know if this" +
                    " product is effective. Exercise great caution while using this product"
        }

        else {

            // 2. analyze ingredients for Avobenzene related issues
            val avoWarnings : String = getAvobenzoneWarnings(ingredients)

            // 3. analyze ingredients for mineral sunscreen ingredients
            val mineralWarning : String = getMineralWarnings(ingredients)

            // 4. create text that will be uploaded to the textview
            var warnings = ""

            // 5. update the warnings
            for( i  in arrayOf(avoWarnings, mineralWarning)){
                if(i == ""){
                    continue
                }
                warnings += i + "\n\n"
            }

            // 6. remove the extra \n\n at the end
            if(warnings.length > 3) {
                warnings = warnings.substring(0, warnings.length - 3)
            }

            // 6. update the warning label
            tvIngredientWarnings.text = warnings

        }
    }

    private fun updateBlockingLabel(absA: Float, absB: Float) {
        // get reference to the textview
        val tvIngredients : TextView = findViewById(R.id.tvBlockageInfo)

        var processedA : Int = 0
        var processedB : Int = 0
        if(absA > 0.99){
            processedA  = 99
        } else {
            processedA = (absA * 100) .toInt()
        }

        if(absB > 0.99){
            processedB  = 99
        } else {
            processedB = (absB * 100).toInt()
        }

        // update text
        tvIngredients.text = "• ${processedA}% of UVA rays \n• ${processedB}% of UVB rays"
    }

    private fun checkActiveIngredientsProvided(finalSpectrum: MutableMap<String, Float>): Boolean {
        for((key, value) in finalSpectrum){
            if(value > 0.0){
                return false // there is some spectrum
            }
        }
        return true // there is no spectrum
    }
    private fun getMineralWarnings(ingredients: MutableList<Pair<String, Float>>): String {
        // extract the names of all the active ingredients
        val ingredientNames = mutableListOf<String>()
        for(i in ingredients){
            ingredientNames.add(i.first)
        }

        // string that will hold output of function
        var outputString = ""
        var mineralsFound = 0

        // check for titanium and zinc
        if(ingredientNames.contains(titanium_dioxide_names[0])) {
            mineralsFound += 1
        }
        if(ingredientNames.contains(zinc_oxide_names[0])){
            mineralsFound += 2
        }

        when(mineralsFound){
            0 -> outputString = ""
            1 -> outputString = "• This sunscreen contains titanium dioxide"
            2 -> outputString = "• This sunscreen contains zinc oxide"
            3 -> outputString = "• This sunscreen contains titanium dioxide and zinc oxide"
        }

        if(mineralsFound > 0) {
            outputString += " which can make your skin appear whiter."
        }

        return outputString
    }

    private fun updateIngredients(ingredients: MutableList<Pair<String, Float>>) {

        // get reference to the ingredients label
        val tvIngredients : TextView = findViewById(R.id.tvIngredients)

        var fIngredients = ""
        for((ing, incorp) in ingredients){

            // remove underscores
            var fI = ing.replace("_", " ")

            if(activeIngredientsNotProvided == true){
                fIngredients += "• $fI ?? %\n"
            } else {
                fIngredients += "• $fI, $incorp%\n"
            }

        }

        tvIngredients.text = fIngredients
    }

    private fun getAvobenzoneWarnings(ingredients: MutableList<Pair<String, Float>>): String {

        // should also add if water proof or not

        // extract the names of all the active ingredients
        val ingredientNames = mutableListOf<String>()
        for(i in ingredients){
            ingredientNames.add(i.first)
        }

        // a fantastic broad band sunscreen ingredient that needs stabilizing.
        if(ingredientNames.contains(avobenzone_names[0])) {

            var outputString = ""

            outputString += "• Avobenzone is an excellent UVA/UVB blocker, " +
                    "however, it is destroyed by sunlight unless paired with a stabilizer."


            // check if there are any good stabilizers in the ingredients
            var goodAvobenzoneStabilizersFound = mutableListOf<String>()
            for(i in ingredientNames){
                for(stabilizer in goodAvobenzoneStabilizers){
                    if( i == stabilizer){
                        goodAvobenzoneStabilizersFound.add(stabilizer)
                    }
                }
            }

            // case 1: some good stabilizers of avobenzone were found
            if(goodAvobenzoneStabilizersFound.size == 1) {

                outputString += " This sunscreen contains ${goodAvobenzoneStabilizersFound[0]}" +
                        " which is a good stabilizer of Avobenzone. Nothing to worry about!"

            } else if (goodAvobenzoneStabilizersFound.size > 1) {

                outputString += " This sunscreen uses "

                for(i in 0..goodAvobenzoneStabilizersFound.size -1){

                    if(i == goodAvobenzoneStabilizersFound.size - 1){
                        outputString += "and ${goodAvobenzoneStabilizersFound[i]}"
                    } else {
                        outputString += "${goodAvobenzoneStabilizersFound[i]}, "
                    }
                }
                outputString += " which are good stabilizers of Avobenzone. Nothing to worry about!"
            }


            // case 2: no good avobenzone stabilizers were found, but maybe there are some
            // stabilizers that are not terrible
            if(goodAvobenzoneStabilizersFound.size == 0){
                // check if there are bad stabilizers

                var badAvobenzoneStabilizersFound = mutableListOf<String>()
                for(i in ingredientNames){
                    for(stabilizer in badAvobenzoneStabilizers){
                        if( i == stabilizer){
                            badAvobenzoneStabilizersFound.add(i)
                        }
                    }
                }

                if(badAvobenzoneStabilizersFound.size == 1) {

                    outputString += " This sunscreen has ${badAvobenzoneStabilizersFound[0]}" +
                        " which is a moderately poor stabilizer of Avobenzone."  +
                        "We strongly suggest you consider using a different sunscreen"

                } else if (badAvobenzoneStabilizersFound.size > 1) {

                    outputString += " This sunscreen uses "

                    for(i in 0..badAvobenzoneStabilizersFound.size -1){

                        if(i == badAvobenzoneStabilizersFound.size - 1){
                            outputString += "and ${badAvobenzoneStabilizersFound[i]}"
                        } else {
                            outputString += "${badAvobenzoneStabilizersFound[i]}, "
                        }
                    }
                    outputString += " which are poor stabilizers of Avobenzone. Together, they may" +
                        "be sufficient to stabilize Avobezone, but we suggest you consider using " +
                        "a different sunscreen"
                }

                else if(badAvobenzoneStabilizersFound.size == 0){
                    outputString += " This sunscreen contains no known stabilizers. We strongly" +
                            "suggest you consider using a different sunscreen"
                }
            }

            return outputString
        }

        // if avobenzone is not in the list of ingredients
        else if(!ingredientNames.contains(avobenzone_names[0])) {
            return ""
        }
        return ""
    }

    private fun getAreaUnderGraph(spectrum: MutableMap<String, Float>, start: Int, end: Int) : Float{
        var total = 0f

        var prevWL : String = ""
        var prevVal : Float = -1f
        var doAdd = false
        spectrum.forEach { (wavelength, value) ->
            // 1. start adding the values
            if(wavelength == start.toString()){
                doAdd = true
                prevWL = wavelength
                prevVal = value
            }

            // stop adding the values
            if(wavelength > end.toString()){
                doAdd = false
            }

            if(doAdd){
                //Log.i(TAG, "wl : $wavelength")
                val width = wavelength.toInt() - prevWL.toInt()
                //Log.i(TAG, "width : $width")
                val avgVal = (prevVal + value) /2
                //Log.i(TAG, "avg value : $avgVal")
                val area = width * avgVal

                prevWL = wavelength
                prevVal = value
                total += area
            }

        }

        return total

    }
}