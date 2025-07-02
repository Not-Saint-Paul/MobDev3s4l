package com.example.mobdev_3s_4l

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val context: Context, private val list: ArrayList<ColorData>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val colorData = list[position]
        holder.bind(colorData)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(colorData: ColorData) {
            val textView = itemView.findViewById<TextView>(R.id.rView_textView)
            val view = itemView.findViewById<View>(R.id.rView_view)

            textView.text = colorData.colorName
            view.setBackgroundColor(colorData.colorHex.toInt())
        }
    }
}