package com.example.crestie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

class SlideFragment : Fragment() {

    lateinit var models:ArrayList<Model>
    lateinit var adapter:Adapter
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_slide, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        models = ArrayList<Model>()
        models.add(Model(R.drawable.ian, "Ian", "+106days"))
        models.add(Model(R.drawable.kkaemo, "Kkaemo", "+658days"))
        models.add(Model(R.drawable.doomo, "Doomo", "+642days"))
        models.add(Model(R.drawable.semo, "Semo", "+459days"))

        adapter = Adapter(models, view.context)

        viewPager = view.findViewById(R.id.viewPager)
        viewPager.adapter = adapter
        viewPager.setPadding(130, 0, 130, 0)

        viewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

            }

        })
    }
}