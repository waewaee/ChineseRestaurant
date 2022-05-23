package com.waewaee.chineserestaurant

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    lateinit var sharedPreference: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    var price = 0L
    companion object{
        fun newInstance(context: Context,foodVO:FoodVO):Intent{
            var intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("Food",foodVO)
            return intent
        }
        fun newInstance(context: Context,drinkVO: DrinkVO):Intent{
            var intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("Drink",drinkVO)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        sharedPreference = getSharedPreferences("Cart", Context.MODE_PRIVATE)
        editor = sharedPreference.edit()
        if(intent.hasExtra("Food")){
            var foodVO = intent.getSerializableExtra("Food") as FoodVO
            tvName.text = foodVO.name
            tvPrice.text = "${foodVO.price} "
            tvIngredient.text = foodVO.ingredients
            tvTopping.visibility = View.GONE
            tvType.text = foodVO.type
            tvFlavour.text = foodVO.flavor
            price = foodVO.price
        }else{
            var drinkVO = intent.getSerializableExtra("Drink") as DrinkVO
            tvName.text = drinkVO.name
            tvPrice.text = "${drinkVO.price} "
            tvIngredient.visibility = View.GONE
            tvTopping.text = drinkVO.topping
            tvType.text = drinkVO.type
            tvFlavour.text = drinkVO.flavour
            price = drinkVO.price
        }

        btnCart.setOnClickListener {
            var temp: Long = sharedPreference.getLong("total", 0)
            price += temp
            editor.putLong("total",price)
            editor.apply()
            finish()
        }
    }


}