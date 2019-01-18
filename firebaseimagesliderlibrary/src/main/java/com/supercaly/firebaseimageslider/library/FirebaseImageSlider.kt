package com.supercaly.firebaseimageslider.library

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.viewpager.widget.ViewPager
import com.google.firebase.storage.FirebaseStorage

class FirebaseImageSlider(c: Context, attrs: AttributeSet?): RelativeLayout(c, attrs) {
    companion object {
        private const val TAG = "FirebaseImageSlider"
    }

    private var mPlaceholderResource: Int = R.color.default_placeholder_color
    private var mViewPager: ViewPager
    private var mAdapter: FisAdapter
    private var mClickListener: OnClickListener? = null

    constructor(c: Context) : this(c, null)

    init {
        LayoutInflater.from(c).inflate(R.layout.fis_layout, this, true)

        mViewPager = findViewById(R.id.fis_view_pager)
        mAdapter = FisAdapter()

        mViewPager.adapter = mAdapter

        //Get the placeholder resource from attributes
        attrs?.let {
            val typedArray = c.obtainStyledAttributes(it, R.styleable.FirebaseImageSlider, 0, 0)
            try {
                mPlaceholderResource = typedArray.getResourceId(
                    R.styleable.FirebaseImageSlider_placeholder_image,
                    R.color.default_placeholder_color
                )

            } finally {
                typedArray.recycle()
            }
        }

        Log.i(TAG, "init: $TAG Initialized!!")
    }

    fun setData(list: List<String>?) {
        list?.let {
            val reference = FirebaseStorage.getInstance().reference
            for (value: String in list) {
                reference.child(value).downloadUrl
                    .addOnSuccessListener {url ->
                        Log.d(TAG, "setData: $url")
                        mAdapter.addData(FisSlider(context, url.toString(), mPlaceholderResource))
                    }
                    .addOnFailureListener {
                        Log.e(TAG, "Error getting url for $value")
                    }
            }
        }
    }

    // TODO: 25/12/18 Implement a click listener in the whole view pager
    fun setOnClickListener(l: OnClickListener){
        mClickListener = l
    }

    interface OnClickListener{
        fun onClick(urls: List<String?>)
    }
}