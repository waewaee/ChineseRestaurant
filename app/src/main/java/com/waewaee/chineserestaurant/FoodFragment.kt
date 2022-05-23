package com.waewaee.chineserestaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_food.*

class FoodFragment: Fragment(), FoodDelegate {
    var foodList : ArrayList<FoodVO> = ArrayList()
    companion object {
        fun newInstance(): FoodFragment {
            return FoodFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI()
    }

    private fun setupUI(){
        foodList.add(FoodVO("F_001","Corn Snack",1000,"Snack","Corn,Sticky Rice","Sweet"))
        foodList.add(FoodVO("F_002","Tha Wah",500,"Snack","Sugar,Ginger,Bean","Sweet"))
        foodList.add(FoodVO("F_003","SarTay",2000,"Snack","Chicken,Pork,Peanut","Sweet,Spicy"))
        foodList.add(FoodVO("F_004","Pork Sticks",100,"Snack","Pork","Sweet,Spicy"))
        foodList.add(FoodVO("F_005","Mala Xiang Guo",10000,"Side Dish","Chicken,Pork,SeaFood,Vegetables,Noodles","Spicy"))
        foodList.add(FoodVO("F_006","Mala Curry",5000,"Side Dish","Chicken,Pork,SeaFood,Vegetables","Spicy"))
        foodList.add(FoodVO("F_007","Pork Sticky Rice",1000,"Snack","Pork,Sticky Rice,Egg,Mushroom","Sweet,Spicy"))
        foodList.add(FoodVO("F_008","Aww Kwe Kyi",1000,"Snack","Rice,Vegetable,Pork","Sweet,Spicy"))
        foodList.add(FoodVO("F_009","Dumplings",2000,"Side Dish","Rice,Pork,Chicken,Ginger,Vegetables","Sweet,Spicy"))
        foodList.add(FoodVO("F_010","Three layer Rice Cake",2000,"Snack","Rice,Sugar,Coconut Milk","Sweet"))
        foodList.add(FoodVO("F_011","Fried-Glue Chips",2000,"Side Dish","Prawn,Crab,Corn Starch","Sweet,Spicy"))
        foodList.add(FoodVO("F_012","Chinese Aw Pon",2500,"Main Dish","Meat,Sweet Potato,Vegetable,Rice","Sweet,Spicy"))
        foodList.add(FoodVO("F_013","Pounded Mango",1500,"Side Dish","Mango,Dried Prawns,Fish Paste,Chili Powder","Sour and Spicy"))
        foodList.add(FoodVO("F_014","Fried Vegetables Salad",1500,"Main Dish","Fried Vegetables,Tomato,Chili Powder","Sour and Spicy"))
        foodList.add(FoodVO("F_015","Tofu Salad",1500,"Main Dish","Tofu,Termarine Sauce,Chili Powder","Sour and Spicy"))
        var adapter = FoodAdapter(foodList, this)
        rvFood.layoutManager = LinearLayoutManager(context)
        rvFood.adapter = adapter
    }

    override fun clickFood(foodVO: FoodVO) {
        startActivity(DetailActivity.newInstance(requireContext(), foodVO))
    }

}