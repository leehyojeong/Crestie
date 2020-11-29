package com.example.crestie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CardFragment : Fragment() {

    var models = ArrayList<Model>()
    lateinit var adapter:CardAdapter
    lateinit var recylcerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        빈 배열일 때만 데이터 입력
        if(models.size==0){
            models.add(Model(R.drawable.ian, "Ian", "+106days"))
            models.add(Model(R.drawable.kkaemo, "Kkaemo", "+658days"))
            models.add(Model(R.drawable.doomo, "Doomo", "+642days"))
            models.add(Model(R.drawable.semo, "Semo", "+459days"))
            models.add(Model(R.drawable.ian, "Ian", "+106days"))
            models.add(Model(R.drawable.kkaemo, "Kkaemo", "+658days"))
            models.add(Model(R.drawable.doomo, "Doomo", "+642days"))
            models.add(Model(R.drawable.semo, "Semo", "+459days"))
        }
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CardAdapter(view.context, models)

        recylcerView = view.findViewById(R.id.recylerView)
        recylcerView.adapter = adapter

//        레이아웃 그리드로 변경
        val gm = GridLayoutManager(view.context,2)
        recylcerView.layoutManager = gm
//        아이템 자주 추가/삭제 시 view 크기 변경으로 인한 오류 방지
        recylcerView.setHasFixedSize(true)

    }
}