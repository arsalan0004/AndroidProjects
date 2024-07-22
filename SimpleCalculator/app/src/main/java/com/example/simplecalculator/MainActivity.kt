package com.example.simplecalculator

import android.animation.ArgbEvaluator
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//import androidx.vectordrawable.graphics.drawable.ArgbEvaluator
import androidx.activity.ComponentActivity

private const val TAG : String = "MainActivity"
private const val INITIAL_TIP_PERCENT = 15
class MainActivity : AppCompatActivity() {

    // the views in this program
    private lateinit var etBaseAmount : EditText
    private lateinit var seekBarTip : SeekBar
    private lateinit var tvTipPercentLabel : TextView
    private lateinit var tvTipAmountLabel : TextView
    private lateinit var tvTotalAmount : TextView
    private lateinit var tvTipDescriptionLabel : TextView

    override fun onCreate(savedInstanceState: Bundle?) {




        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvLoveMessege)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // initialize the views in the program
        etBaseAmount = findViewById(R.id.etBaseAmount)
        seekBarTip   = findViewById(R.id.sbTipPercent)
        tvTipPercentLabel = findViewById(R.id.tvTipPercent)
        tvTipAmountLabel = findViewById(R.id.tvTipAmount)
        tvTotalAmount = findViewById(R.id.tvTotalAmount)
        tvTipDescriptionLabel = findViewById(R.id.tvTipDescription)

        // initialize the labels
        seekBarTip.progress = INITIAL_TIP_PERCENT
        tvTipPercentLabel.text   = "$INITIAL_TIP_PERCENT"
        tvTipAmountLabel.text = "0"
        tvTotalAmount.text = "0"
        updateTipDescription(INITIAL_TIP_PERCENT)

        // configure the seekbar
        seekBarTip.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                Log.i(TAG, "progressBar $p1")
                tvTipPercentLabel.text = "${p1}%"
                calculateTipAndTotal()
                updateTipDescription(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        // configure the edit text
        etBaseAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                Log.i(TAG, "amount = $p0")
                calculateTipAndTotal()
            }

        })
    }

    private fun updateTipDescription(tipPercent: Int) {
        val tipDescription = when (tipPercent) {
            in 0..5 -> "poor"
            in 6..10 -> "acceptable"
            in 11..15 -> "good"
            in 16..20 -> "great"
            else -> "amazing"
        }
        tvTipDescriptionLabel.text = tipDescription

        val color = ArgbEvaluator().evaluate(
            tipPercent.toFloat() / seekBarTip.max,
            ContextCompat.getColor(this, R.color.red),
            ContextCompat.getColor(this, R.color.green)
        ) as Int

        tvTipDescriptionLabel.setTextColor(color)
    }

    private fun calculateTipAndTotal() {
        // 0. Get tipPercent and base amount
        val baseAmount = etBaseAmount.text.toString().toDoubleOrNull()

        if(baseAmount == null){
            Log.i(TAG, "base amount read is null")
            return
        }

        val tipPercent = seekBarTip.progress.toDouble()

        // 1. calculate the tip amount
        val tipAmount : Double = baseAmount * tipPercent / 100

        // 2. calculate the total
        val totalAmount = baseAmount + tipAmount

        // 3. display the total and the tip amount
        tvTipAmountLabel.text = "%.2f".format(tipAmount)
        tvTotalAmount.text = "%.2f".format(totalAmount)
    }
}