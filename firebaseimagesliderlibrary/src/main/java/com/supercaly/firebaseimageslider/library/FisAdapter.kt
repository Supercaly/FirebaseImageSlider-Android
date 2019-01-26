package com.supercaly.firebaseimageslider.library

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class FisAdapter: PagerAdapter() {

    companion object {
        private const val TAG = "FisAdapter"
    }

    private var mSliders: ArrayList<FisSlider> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun addData(slider: FisSlider){
        Log.i(TAG, "addData: ")
        mSliders.add(slider)
        notifyDataSetChanged()
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        Log.d(TAG, "instantiateItem: $position")
        container.addView(mSliders[position].imageView)
        return mSliders[position].imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        Log.d(TAG, "destroyItem: $position")
        container.removeView(mSliders[position].imageView)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean { return view == `object` }

    override fun getCount(): Int { return mSliders.size }
}
