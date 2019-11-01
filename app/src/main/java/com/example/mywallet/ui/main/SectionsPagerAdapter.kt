package com.example.mywallet.ui.main

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mywallet.R

private val TAB_TITLES = arrayOf(
    R.string.balance,
    R.string.transactions,
    R.string.statistics,
    R.string.settings
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    private val TAG = "SectionsPagerAdapter"

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Balance.newInstance()
            1 -> Transactions.newInstance()
            2 -> Statistics.newInstance()
            3 -> Settings.newInstance()
            else -> {
                Log.w(TAG, "getItem invoked on $position which is irregular.")
                getItem(0)
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 4
    }
}