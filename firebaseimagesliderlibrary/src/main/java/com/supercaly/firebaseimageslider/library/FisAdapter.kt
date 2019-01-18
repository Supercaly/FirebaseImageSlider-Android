package com.supercaly.firebaseimageslider.library

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class FisAdapter: PagerAdapter() {
    companion object {
        private const val TAG = "FisAdapter"
    }

    var mSliders: ArrayList<FisSlider> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun addData(s: FisSlider){
        Log.i(TAG, "addData: ")
        mSliders.add(s)
        notifyDataSetChanged()
    }

    fun getUrls(): List<String?> {
        val list = ArrayList<String?>()
        for (slider in mSliders){
            list.add(slider.url)
        }
        return list
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        Log.d(TAG, "instantiateItem: $position")
        val current = mSliders[position]
        container.addView(current)
        return current
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        Log.d(TAG, "destroyItem: $position")
        container.removeView(mSliders[position])
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean { return view == `object` }

    override fun getCount(): Int { return mSliders.size }
}
