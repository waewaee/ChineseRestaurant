package com.waewaee.chineserestaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_drink.*
import kotlinx.android.synthetic.main.fragment_food.*

class DrinkFragment: Fragment(), DrinkDelegate {
    var drinkList : ArrayList<DrinkVO> = ArrayList()
    companion object {
        fun newInstance(): DrinkFragment {
            return DrinkFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_drink, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI()
    }

    private fun setupUI(){
        drinkList.add(DrinkVO("D_001","Lime Green Tea",2500,"Tea","Jelly,Bubble","Sour and Sweet"))
        drinkList.add(DrinkVO("D_002","Soy Milk",1500,"Milk","Jelly,Bubble","Sweet"))
        drinkList.add(DrinkVO("D_003","Pomegranate Juice",2000,"Juice","Jelly","Sour and Sweet"))
        drinkList.add(DrinkVO("D_004","WaterMelon Juice",2000,"Juice","Jelly","Sweet"))
        drinkList.add(DrinkVO("D_005","Chocolate Milkshake",2500,"Milkshake","Bubble","Sweet"))
        var adapter = DrinkAdapter(drinkList, this)
        rvDrink.layoutManager = LinearLayoutManager(context)
        rvDrink.adapter = adapter
    }

    override fun clickDrink(drinkVO: DrinkVO) {
        startActivity(DetailActivity.newInstance(requireContext(), drinkVO))
    }
}