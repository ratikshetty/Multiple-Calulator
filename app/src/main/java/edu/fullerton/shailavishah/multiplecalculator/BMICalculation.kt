package edu.fullerton.shailavishah.multiplecalculator

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_bmicalculation.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class BMICalculation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculation)

        feetEditText!!.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (feetEditText!!.text.toString() == "" || inchesEditText!!.text.toString() == "" || weightEditText!!.text.toString() == "") {
                    resultTextView!!.text = ""
                } else {
                    calculateResult(java.lang.Double.parseDouble(feetEditText!!.text.toString()),
                        java.lang.Double.parseDouble(inchesEditText!!.text.toString()),
                        java.lang.Double.parseDouble(weightEditText!!.text.toString()))
                }
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        inchesEditText!!.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (feetEditText!!.text.toString() == "" || inchesEditText!!.text.toString() == "" || weightEditText!!.text.toString() == "") {
                    resultTextView!!.text = ""
                } else {
                    calculateResult(java.lang.Double.parseDouble(feetEditText!!.text.toString()),
                        java.lang.Double.parseDouble(inchesEditText!!.text.toString()),
                        java.lang.Double.parseDouble(weightEditText!!.text.toString()))
                }
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        weightEditText!!.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (feetEditText!!.text.toString() == "" || inchesEditText!!.text.toString() == "" || weightEditText!!.text.toString() == "") {
                    resultTextView!!.text = ""
                } else {
                    calculateResult(java.lang.Double.parseDouble(feetEditText!!.text.toString()),
                        java.lang.Double.parseDouble(inchesEditText!!.text.toString()),
                        java.lang.Double.parseDouble(weightEditText!!.text.toString()))
                }
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
    }

    private fun calculateResult(feet: Double, inches: Double, weight: Double) {
        val heightInFeet = feet
        val heightInches = inches
        val weightInPounds = weight

        val weightMetric: Double = weightInPounds * 0.45
        val heightMetric: Double = ((heightInFeet * 12) + heightInches) * 0.025
        val squareHeight: Double = heightMetric * heightMetric

        val output: Double = weightMetric / squareHeight

        val pattern = "#.#"
        val decimalFormat = DecimalFormat(pattern)
        resultTextView!!.setTypeface(resultTextView!!.typeface, Typeface.BOLD)
        resultTextView!!.text = getString(R.string.out_message) + " " + decimalFormat.format(output).toString()
    }
}
