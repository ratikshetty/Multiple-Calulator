package edu.fullerton.shailavishah.multiplecalculator

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_volume_calculation.*
import java.text.DecimalFormat

class VolumeCalculation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume_calculation)

        val units = arrayOf("miles", "yards", "feet", "inches", "kilometers", "centimeters", "millimeters", "micrometers", "nanometers", "angstroms")

        if(spinner != null) {
            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
            spinner.adapter = arrayAdapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    //Toast.makeText(this@MainActivity, "Selected item is " + " " + units[position], Toast.LENGTH_SHORT).show()
                    if(sphereRadius!!.text.toString() != ""){
                        calculateSphereVolume(java.lang.Double.parseDouble(sphereRadius!!.text.toString()), units[position])
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Code to perform some action when nothing is selected
                    if(sphereRadius!!.text.toString() != ""){
                        calculateSphereVolume(java.lang.Double.parseDouble(sphereRadius!!.text.toString()), units[parent.selectedItemPosition])

                    }
                }
            }



        }

        sphereRadius!!.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (sphereRadius!!.text.toString() == "" ) {
                    sphereVolumeResult!!.text = ""
                } else {
                    calculateSphereVolume(java.lang.Double.parseDouble(sphereRadius!!.text.toString()), units[0])
                }
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        if(spinner2 != null) {
            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
            spinner2.adapter = arrayAdapter

            spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    //Toast.makeText(this@MainActivity, "Selected item is " + " " + units[position], Toast.LENGTH_SHORT).show()
                    if(cubeRadius!!.text.toString() != ""){
                        calculateCubeVolume(java.lang.Double.parseDouble(cubeRadius!!.text.toString()), units[position])
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Code to perform some action when nothing is selected
                    if(cubeRadius!!.text.toString() != ""){
                        calculateCubeVolume(java.lang.Double.parseDouble(cubeRadius!!.text.toString()), units[parent.selectedItemPosition])

                    }
                }
            }

        }

        cubeRadius!!.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (cubeRadius!!.text.toString() == "" ) {
                    cubeVolumeResult!!.text = ""
                } else {
                    calculateCubeVolume(java.lang.Double.parseDouble(cubeRadius!!.text.toString()), units[0])
                }
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
    }

    private fun calculateSphereVolume(radius: Double, unit : String){
        val rad : Double = radius
        val ut : String = unit
        val result : Double = (4/3) * (22/7) * rad * rad * rad
        val pattern = "#.#"
        val decimalFormat = DecimalFormat(pattern)
        sphereVolumeResult!!.setTypeface(sphereVolumeResult!!.typeface, Typeface.BOLD)
        sphereVolumeResult!!.text = getString(R.string.sphere_volume) +
                " = " +decimalFormat.format(result).toString() + " " + ut +"^3"
    }

    private fun calculateCubeVolume(radius: Double, unit : String){
        val result: Double = radius * radius * radius
        val pattern = "#.#"
        val decimalFormat = DecimalFormat(pattern)
        cubeVolumeResult!!.setTypeface(sphereVolumeResult!!.typeface, Typeface.BOLD)
        cubeVolumeResult!!.text = getString(R.string.cube_volume) +
                " = " +decimalFormat.format(result).toString() + " " + unit +"^3"

    }
}
