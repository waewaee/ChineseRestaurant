package com.waewaee.chineserestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_holder_food.view.*

class DrinkAdapter(var drinkList: ArrayList<DrinkVO>, var delegate: DrinkDelegate): RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>() {
    class DrinkViewHolder(itemView: View, var delegate: DrinkDelegate): RecyclerView.ViewHolder(itemView){
        fun bindData(data: DrinkVO){
            itemView.tvName.text = data.name
            itemView.tvPrice.text = "${data.price} MMK"
            itemView.setOnClickListener{
                delegate.clickDrink(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkAdapter.DrinkViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_drink, parent, false)
        return DrinkAdapter.DrinkViewHolder(view, delegate)
    }

    override fun getItemCount(): Int {
        return drinkList.size
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.bindData(drinkList[position])
    }

}

