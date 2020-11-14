package com.example.crestie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class Adapter(): PagerAdapter() {

    private lateinit var models:List<Model>
    private lateinit var layoutInflater:LayoutInflater
    private lateinit var context:Context

    constructor(models: List<Model>, context: Context) :this(){
        this.models = models
        this.context = context
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
//        인자로 받은 두 개가 일치할 때만 반환
        return view == `object`
    }

    override fun getCount(): Int {
        return models.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(context)
        var view:View = layoutInflater.inflate(R.layout.item, container, false)

        var imageView:ImageView
        var title:TextView
        var desc:TextView

        imageView = view.findViewById(R.id.image)
        title = view.findViewById(R.id.title)
        desc = view.findViewById(R.id.desc)

        imageView.setImageResource(models.get(position).getImage())
        title.text = models.get(position).getTitle().toString()
        desc.text = models.get(position).getText().toString()

        container.addView(view, 0)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}