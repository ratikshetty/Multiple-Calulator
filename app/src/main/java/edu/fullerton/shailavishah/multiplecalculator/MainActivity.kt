package edu.fullerton.shailavishah.multiplecalculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //listview
        var listview = findViewById<ListView>(R.id.calculatorApp)

        var list = mutableListOf<DataModel>()

        //adding item in listview
        list.add(DataModel("Sales Tax",R.drawable.sales))
        list.add(DataModel("Tips", R.drawable.tips))
        list.add(DataModel("Volume",R.mipmap.volume))
        list.add(DataModel("Body Mass Index",R.drawable.bmi))

        //adapter
        listview.adapter = MyListAdapter(this, R.layout.row, list)

        //listview item clicks
        listview.setOnItemClickListener { parent:AdapterView<*>, view:View , position :Int, id:Long ->
            if (position == 0) {
                val intent = Intent(view.context, SalestaxCalculation::class.java)
                view.context.startActivity(intent)
                //Toast.makeText(this@MainActivity, "Calculator 1 clicked....", Toast.LENGTH_SHORT).show()
            }
            if (position == 1) {
                val intent = Intent(view.context, TipsCalculation::class.java)
                view.context.startActivity(intent)
                //Toast.makeText(this@MainActivity, "Calculator 2 clicked....", Toast.LENGTH_SHORT).show()
            }
            if (position == 2) {
                 val intent = Intent(view.context, VolumeCalculation::class.java)
                 view.context.startActivity(intent)
                 //Toast.makeText(this@MainActivity, "Calculator 3 clicked....", Toast.LENGTH_SHORT).show()
             }
            if (position == 3) {
                 val intent = Intent(view.context, BMICalculation::class.java)
                 view.context.startActivity(intent)
                 //Toast.makeText(this@MainActivity, "Calculator 4 clicked....", Toast.LENGTH_SHORT).show()
             }
        }
    }
}
