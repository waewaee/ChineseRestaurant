package com.waewaee.chineserestaurant

import java.io.Serializable

class FoodVO (
        var id: String = "",
        var name: String = "",
        var price: Long = 0,
        var type: String = "",
        var ingredients: String = "",
        var flavor: String = ""
): Serializable