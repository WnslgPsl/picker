package xyz.android.picker.presentation.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import xyz.android.picker.BR

abstract class BaseBindingViewHolder<out B : ViewDataBinding>(val binding: B) :
    RecyclerView.ViewHolder(binding.root) {

    open fun <T> bind(data: T) {
        binding.setVariable(BR.item, data)
        binding.executePendingBindings()
    }
}