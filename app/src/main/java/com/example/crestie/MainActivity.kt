package com.example.crestie

import android.animation.ArgbEvaluator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var argbEvaluator:ArgbEvaluator = ArgbEvaluator()

    val manager = supportFragmentManager
    lateinit var changeBtn:Button
    lateinit var slideFragment: SlideFragment
    lateinit var cardFragment: CardFragment
    var flag:Boolean=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        slideFragment = SlideFragment()
        cardFragment = CardFragment()

//        처음 화면은 슬라이드 화면
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,slideFragment).commit()

//        버튼 누르면 프래그먼트 전환
        changeBtn = findViewById(R.id.changeBtn)
        changeBtn.setOnClickListener(View.OnClickListener {
            if(flag){
                changeBtn.setBackgroundResource(R.drawable.ic_cardchange)
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout,cardFragment).commit()
                flag=false
            }else{
                changeBtn.setBackgroundResource(R.drawable.ic_slidechange)
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout,slideFragment).commit()
                flag=true
            }
        })
    }
}
