package com.tonib.pocketnotes.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tonib.pocketnotes.view.fragments.notes.NotesFragment
import com.tonib.pocketnotes.view.fragments.todo.TodosFragment

private const val PAGES_COUNT = 2

class MainScreenPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = PAGES_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                NotesFragment.instance()
            }
            1 -> {
                TodosFragment.instance()
            }
            else -> {
                NotesFragment.instance()
            }
        }
    }

}