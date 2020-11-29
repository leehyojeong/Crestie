package com.example.crestie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(val context:Context, val models:ArrayList<Model>)
    :RecyclerView.Adapter<CardAdapter.Holder>() {

    inner class Holder(itemView: View?):RecyclerView.ViewHolder(itemView!!) {
        val imageView = itemView?.findViewById<ImageView>(R.id.mainImage)
        val nameView = itemView?.findViewById<TextView>(R.id.nameText)
        val dayView = itemView?.findViewById<TextView>(R.id.dayText)

        fun bind(model:Model, context: Context) {
            val resourceId = context.resources
                .getIdentifier(model.getImage().toString(), "drawable", context.packageName)
            imageView?.setImageResource(resourceId)

            nameView?.text = model.getTitle()
            dayView?.text = model.getText()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.small_card, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(models[position],context)
    }
}