package com.example.lab_week_4

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

val TABS_FIXED = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title,
)

class CafeAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, private val context: Context) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = TABS_FIXED.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CafeDetailFragment.newInstance(
                context.getString(R.string.starbucks_title),
                context.getString(R.string.starbucks_desc)
            )
            1 -> CafeDetailFragment.newInstance(
                context.getString(R.string.janjijiwa_title),
                context.getString(R.string.janjijiwa_desc)
            )
            2 -> CafeDetailFragment.newInstance(
                context.getString(R.string.kopikenangan_title),
                context.getString(R.string.kopikenangan_desc)
            )
            else -> throw IllegalStateException("Invalid position $position")
        }
    }
}

