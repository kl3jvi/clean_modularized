package com.kl3jvi.feature_home.presentation.adpater

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<out T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onClickAdapter(view: View, element: @UnsafeVariance T)
    open fun bindView(element: @UnsafeVariance T) {}
}