package com.waewaee.chineserestaurant

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    companion object{
        fun newInstance(mContext: Context): Intent {
            return Intent(mContext, MenuActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        vpMenu.adapter = MenuFragmentAdapter(supportFragmentManager)
        navView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_food -> {
                    supportActionBar?.title ="Food"
                    vpMenu.currentItem = 0
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_drink -> {
                    supportActionBar?.title ="Drink"
                    vpMenu.currentItem = 1
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })

        vpMenu.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> {
                        supportActionBar?.title ="Food"
                        navView.menu.findItem(R.id.nav_food).isChecked = true
                    }
                    1 -> {
                        supportActionBar?.title ="Drink"
                        navView.menu.findItem(R.id.nav_drink).isChecked = true
                    }
                }
            }
        })
    }
}