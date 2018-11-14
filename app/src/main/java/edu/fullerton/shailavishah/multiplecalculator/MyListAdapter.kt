package edu.fullerton.shailavishah.multiplecalculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyListAdapter(var calCtx: Context, var resource: Int, var calItems:List<DataModel>)
    :ArrayAdapter<DataModel>(calCtx, resource, calItems){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //inflate Layout
        val layoutInflater:LayoutInflater = LayoutInflater.from(calCtx)

        val view:View = layoutInflater.inflate(resource,null)

        val imageView:ImageView = view.findViewById(R.id.calculatorIcon)
        val textView:TextView = view.findViewById(R.id.calculatorText)

        var items:DataModel = calItems[position]

        imageView.setImageDrawable(calCtx.resources.getDrawable(items.photo))
        textView.text = items.title
        return view
    }
}