package com.waewaee.chineserestaurant

import java.io.Serializable

class DrinkVO (
        var id : String ="",
        var name : String = "",
        var price : Long = 0,
        var type : String = "",
        var topping : String = "",
        var flavour : String = ""

): Serializable