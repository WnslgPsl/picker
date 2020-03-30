package xyz.android.picker.presentation.ui

import xyz.android.picker.databinding.PickerListItemViewBinding
import xyz.android.picker.presentation.base.BaseBindingViewHolder

class PickerItemViewHolder(
    binding: PickerListItemViewBinding,
    onClickItem: (Int) -> Unit,
    onLongClickItem: (Int) -> Unit
    ) : BaseBindingViewHolder<PickerListItemViewBinding>(binding) {

    init {
        itemView.setOnClickListener {
            onClickItem(adapterPosition)
        }

        itemView.setOnLongClickListener {
            onLongClickItem(adapterPosition)
            true
        }
    }

}