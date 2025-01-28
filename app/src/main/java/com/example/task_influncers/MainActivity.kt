package com.example.task_influncers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        val adapter = TabsPagerAdapter(this)
        viewPager.adapter = adapter

        val tabTitles = listOf("Apple", "BMW", "Myntra", "Amazon", "CarChalao")

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]  // ✅ Adding text to tabs
            tab.contentDescription = "Tab ${tabTitles[position]}"  // ✅ Accessibility support
        }.attach()
    }
}
