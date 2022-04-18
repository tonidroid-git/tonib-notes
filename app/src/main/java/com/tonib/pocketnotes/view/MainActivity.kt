package com.tonib.pocketnotes.view

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.tonib.pocketnotes.R
import com.tonib.pocketnotes.databinding.ActivityMainBinding


private val pageTitles = listOf("Notes", "ToDo's")

class MainActivity : FragmentActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.appBottomBar.background = null
        val transition = binding.fabNew.background

        // setup viewPager
        val tabLayout = binding.tabLayout

        viewPager = binding.viewPager
        viewPager.adapter = MainScreenPagerAdapter(this)
        viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback () {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if (position == 0) {
                        binding.fabNew.setImageResource(R.drawable.ic_boy)
                        binding.fabNew.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.purple_200))
                        binding.fabNew.animate().rotation(90f).setDuration(300).start()
//                        transition.startTransition(300)
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    } else {
                        binding.fabNew.setImageResource(R.drawable.ic_test)
                        binding.fabNew.animate().rotation(-90f).setDuration(300).start()
                        binding.fabNew.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.teal_200))
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    }
                }
            }
        )

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