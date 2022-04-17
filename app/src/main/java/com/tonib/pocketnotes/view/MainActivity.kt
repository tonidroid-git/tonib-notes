package com.tonib.pocketnotes.view

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.tonib.pocketnotes.databinding.ActivityMainBinding

private val pageTitles = listOf("Notes", "ToDo's")

class MainActivity : FragmentActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabLayout = binding.tabLayout

        viewPager = binding.viewPager
        viewPager.adapter = MainScreenPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = pageTitles[position]
        }.attach()

    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

}