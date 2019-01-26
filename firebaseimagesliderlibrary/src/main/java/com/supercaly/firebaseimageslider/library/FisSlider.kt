package com.supercaly.firebaseimageslider.library

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class FisSlider(context: Context,
                url: String?,
                placeholderRes: Int = DEFAULT_PLACEHOLDER) {

    companion object {
        private const val TAG = "FisSlider"
        private val DEFAULT_PLACEHOLDER: Int = R.color.default_placeholder_color
    }

    var imageView: ImageView = ImageView(context)


    init {
        imageView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT)

        Glide.with(context)
            .load(url)
            .apply(RequestOptions()
                .centerCrop()
                .placeholder(placeholderRes))
            .into(imageView)

        Log.i(TAG, "init: initialized!!!")
    }
}