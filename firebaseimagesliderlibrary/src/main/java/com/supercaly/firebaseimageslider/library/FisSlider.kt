package com.supercaly.firebaseimageslider.library

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.facebook.drawee.view.SimpleDraweeView


class FisSlider(c: Context,
                attr: AttributeSet?,
                var url: String?,
                placeholderRes: Int = DEFAULT_PLACEHOLDER): LinearLayout(c, attr) {

    companion object {
        private const val TAG = "FisSlider"
        private val DEFAULT_PLACEHOLDER: Int = R.color.default_placeholder_color
    }

    private var mSimpleDraweeView: SimpleDraweeView

    constructor(c: Context): this(c, null)

    constructor(c: Context, attr: AttributeSet?): this(c, attr, null, DEFAULT_PLACEHOLDER)

    constructor(c:Context, url: String, placeholderRes: Int): this(c, null, url, placeholderRes)

    init {
        LayoutInflater.from(c).inflate(R.layout.fis_slider_layout, this, true)
        mSimpleDraweeView = findViewById(R.id.fis_slider_image)

        mSimpleDraweeView.hierarchy.setPlaceholderImage(placeholderRes)
        mSimpleDraweeView.setImageURI(url)

        Log.d(TAG, "init: initialized!!!")
    }
}