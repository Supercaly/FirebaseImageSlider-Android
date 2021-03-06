package com.supercaly.firebaseimageslider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.supercaly.firebaseimageslider.library.FirebaseImageSlider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //Create arrayListOf Strins
        val list = listOf(
            "articles-debug/OI5bWljWBOYvKquBEyEB/773e5c92-5b1f-4540-842f-ea55dc533f1a",
            "articles-debug/OI5bWljWBOYvKquBEyEB/21b0287a-7f73-4d7d-8182-11289c053846",
            "articles-debug/kMbjUpin1WPDE236FkSv/40363274-3aea-4727-bb0f-487ba788f",
            "articles-debug/OI5bWljWBOYvKquBEyEB/773e5c92-5b1f-4540-842f-ea55dc533f1a",
            "articles-debug/OI5bWljWBOYvKquBEyEB/21b0287a-7f73-4d7d-8182-11289c846",
            "articles-debug/kMbjUpin1WPDE236FkSv/40363274-3aea-4727-bb0f-487ba78882cf",
            "articles-debug/OI5bWljWBOYvKquBEyEB/773e5c92-5b1f-4540-842f-ea55dc533f1a",
            "articles-debug/OI5bWljWBOYvKquBEyEB/21b0287a-7f73-4d7d-8182-11289c053846",
            "articles-debug/kMbjUpin1WPDE236FkSv/40363274-3aea-4727-bb0f-487ba78882cf")

        //Find FIS and add data
        val fis = findViewById<FirebaseImageSlider>(R.id.fis)
        fis.images(list)
    }
}
