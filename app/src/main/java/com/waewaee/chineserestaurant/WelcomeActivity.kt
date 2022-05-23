package com.waewaee.chineserestaurant

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.waewaee.chineserestaurant.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    lateinit var sharedPreference: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        sharedPreference = getSharedPreferences("Cart", Context.MODE_PRIVATE)
        editor = sharedPreference.edit()
        btnMenu.setOnClickListener {
            startActivity(MenuActivity.newInstance(this))
        }

        btnPay.setOnClickListener {
            var temp: Long = sharedPreference.getLong("total", 0)
            editor.clear().apply()
            tvCart.text = "0"
            var snackBar = Snackbar.make(layout, "Thank you for your purchase!!", Snackbar.LENGTH_INDEFINITE)
            snackBar.setAction("UNDO") {
                editor.putLong("total", temp)
                tvCart.text = temp.toString()
            }
            snackBar.setActionTextColor(Color.YELLOW)
            val snackbarView = snackBar.view
            val snackbarText = snackbarView.findViewById<View>(R.id.snackbar_text)as TextView
            snackbarText.setTextColor(Color.GREEN)
            snackBar.show()
        }
    }

    override fun onResume() {
        super.onResume()
        tvCart.text = sharedPreference.getLong("total", 0).toString()
    }
}