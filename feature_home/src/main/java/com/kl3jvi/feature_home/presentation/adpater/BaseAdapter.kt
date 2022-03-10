package com.kl3jvi.feature_home.presentation.adpater

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<T, VH : BaseViewHolder<T>>(
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, VH>(diffCallback) {

    open var listener: OnAdapterListener<T>? = null
    open fun removeListener() {
        listener = null
    }
}

interface OnAdapterListener<T> {
    fun onAdapterClick(view: View, data: T)
}