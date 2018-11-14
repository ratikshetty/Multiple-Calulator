package edu.fullerton.shailavishah.multiplecalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher

import kotlinx.android.synthetic.main.activity_sales_tax_calculation.*
import java.text.DecimalFormat

class SalestaxCalculation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sales_tax_calculation)

        txtTotal!!.text=""
        txtTotalTax!!.text=""

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

    private fun Convert(cost: Float, tax: Float) {

        val taxAmount: Float
        val total: Float



        if (cost.toString().equals("0.0") && tax.toString().equals("0.0")) {

            txtTotal!!.text = "Total including Tip: $0."
        } else {

            taxAmount=(cost*(tax/100))
            total=cost+taxAmount
            val value = DecimalFormat("#.#")
            txtTotalTax!!.text = "Total Tax: $" + value.format(taxAmount.toDouble()).toString()
            txtTotal!!.text = "Total Amount: $" + value.format(total.toDouble()).toString()
        }
    }
}
