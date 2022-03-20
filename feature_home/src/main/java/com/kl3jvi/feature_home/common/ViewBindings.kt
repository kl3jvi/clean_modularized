package com.kl3jvi.feature_home.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.request.CachePolicy

object ViewBindings {

    @JvmStatic
    @BindingAdapter("image")
    fun setImage(image: ImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            image.load(url) {
                diskCachePolicy(CachePolicy.ENABLED)
            }
        }
    }
}