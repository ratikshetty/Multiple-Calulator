package edu.fullerton.shailavishah.multiplecalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_tips_calculation.*
import java.text.DecimalFormat

class TipsCalculation : AppCompatActivity() {

    var checked=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips_calculation)

        txtTotal!!.text=""
        txtTotalSplit!!.text=""

        txtBetween.isEnabled=false

        cbSplit.setOnCheckedChangeListener { buttonView, isChecked ->
            if(cbSplit.isChecked){
                checked=1
                txtBetween.isEnabled=true
            }
            else{
                checked=0
                txtBetween.isEnabled=false

            }
            if (txtCost!!.text.toString() == "" || txtTax!!.text.toString() == "" || txtCost!!.text.toString() == "." || txtTax!!.text.toString() == ".") {
                txtTotal!!.text = ""
            } else {
                Convert(java.lang.Float.parseFloat(txtCost!!.text.toString()), java.lang.Float.parseFloat(txtTax!!.text.toString()))
            }
        }

        txtBetween!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (txtCost!!.text.toString() == "" || txtTax!!.text.toString() == "" || txtCost!!.text.toString() == "." || txtTax!!.text.toString() == ".") {
                    txtTotal!!.text = ""
                } else {
                    Convert(java.lang.Float.parseFloat(txtCost!!.text.toString()), java.lang.Float.parseFloat(txtTax!!.text.toString()))
                }

            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        txtCost!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (txtCost!!.text.toString() == "" || txtTax!!.text.toString() == "" || txtCost!!.text.toString() == "." || txtTax!!.text.toString() == ".") {
                    txtTotal!!.text = ""
                } else {
                    Convert(java.lang.Float.parseFloat(txtCost!!.text.toString()), java.lang.Float.parseFloat(txtTax!!.text.toString()))
                }

            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        txtTax!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (txtCost!!.text.toString() == "" || txtTax!!.text.toString() == "" || txtCost!!.text.toString() == "." || txtTax!!.text.toString() == ".") {
                    txtTotal!!.text = ""
                } else {
                    Convert(java.lang.Float.parseFloat(txtCost!!.text.toString()), java.lang.Float.parseFloat(txtTax!!.text.toString()))
                }

            }

            override fun afterTextChanged(s: Editable) {

            }
        })
    }

    private fun Convert(amount: Float, tip: Float) {

        var conversion: Float



        if (amount.toString().equals("0.0") && tip.toString().equals("0.0")) {

            txtTotal!!.text = "Total including Tip: $0."
            txtTotalSplit!!.text = "Total including Tip: $0."
        }
        else {
            conversion = amount + (amount*(tip/100))
            val value = DecimalFormat("#.#")
            txtTotal!!.text = "Total including Tip: $" + value.format(conversion.toDouble()).toString()

            if(checked==1 && txtBetween!!.text.toString()!=""){
                conversion/=java.lang.Float.parseFloat(txtBetween!!.text.toString())
                txtTotalSplit!!.text = "Total Per Person including Tip: $" + value.format(conversion.toDouble()).toString()
            }
            else{
                txtTotalSplit!!.text=""
            }
        }
    }
}
