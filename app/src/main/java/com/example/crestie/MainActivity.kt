package com.example.crestie

import android.animation.ArgbEvaluator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    lateinit var viewPager:ViewPager
    lateinit var adapter:Adapter
    lateinit var models:ArrayList<Model>
    lateinit var colors:ArrayList<Int>
    var argbEvaluator:ArgbEvaluator = ArgbEvaluator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        models = ArrayList<Model>()
        models.add(Model(R.drawable.brochure, "Brochure", "Brochure is an informative paper document"))
        models.add(Model(R.drawable.sticker, "Sticker", "Sticker is a type of label"))
        models.add(Model(R.drawable.poster, "Poster", "Poster is any piece of printed paper designed to be attached"))
        models.add(Model(R.drawable.namecard, "Namecard", "Business cards are cards bearing business information"))

        adapter = Adapter(models, this)

        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = adapter
        viewPager.setPadding(130, 0, 130, 0)

        var colors_temp = ArrayList<Int>()
        colors_temp.add(getResources().getColor(R.color.color1))
        colors_temp.add(getResources().getColor(R.color.color2))
        colors_temp.add(getResources().getColor(R.color.color3))
        colors_temp.add(getResources().getColor(R.color.color4))

        colors = colors_temp

        viewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (position < (adapter.getCount() - 1) && position < (colors.size - 1)) {
                    viewPager.setBackgroundColor(argbEvaluator.evaluate(
                        positionOffset,
                        colors[position],
                        colors[position + 1]) as Int)
                }else{
                    viewPager.setBackgroundColor(colors[colors.size - 1])
                }
            }

            override fun onPageSelected(position: Int) {

            }

        })
    }
}
