package com.example.crestie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

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
        var view:View = layoutInflater.inflate(R.layout.main_card, container, false)

        var imageView:ImageView
        var nameView:TextView
        var daysView:TextView

        imageView = view.findViewById(R.id.mainImage)
        nameView = view.findViewById(R.id.nameText)
        daysView = view.findViewById(R.id.dayText)

        Glide.with(view).load(models.get(position).getImage())
                .apply(RequestOptions.bitmapTransform(RoundedCorners(40)))
                .into(imageView)
//        imageView.setImageResource(models.get(position).getImage())
        nameView.text = models.get(position).getTitle().toString()
        daysView.text = models.get(position).getText().toString()

        container.addView(view, 0)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}