package com.waewaee.chineserestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_holder_food.view.*

class FoodAdapter(var foodList: ArrayList<FoodVO>, var delegate: FoodDelegate): RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    class FoodViewHolder(itemView: View, var delegate: FoodDelegate): RecyclerView.ViewHolder(itemView){
        fun bindData(data: FoodVO){
            itemView.tvName.text = data.name
            itemView.tvPrice.text = "${data.price} MMK"
            itemView.setOnClickListener{
                delegate.clickFood(data)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.FoodViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_food, parent, false)
        return FoodViewHolder(view, delegate)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodAdapter.FoodViewHolder, position: Int) {
        holder.bindData(foodList[position])
    }
}