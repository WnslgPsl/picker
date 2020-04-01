package xyz.android.picker.presentation.ui

import xyz.android.picker.common.extensions.getScreenSize
import xyz.android.picker.databinding.PickerListItemViewBinding
import xyz.android.picker.presentation.base.BaseBindingViewHolder
import xyz.android.picker.presentation.model.PickerMedia

class PickerItemViewHolder(
    binding: PickerListItemViewBinding,
    onClickItem: (Int) -> Unit,
    onLongClickItem: (Int) -> Unit
) : BaseBindingViewHolder<PickerMedia, PickerListItemViewBinding>(binding) {

    var width: Int

    init {
        itemView.setOnClickListener {
            onClickItem(adapterPosition)
        }

        itemView.setOnLongClickListener {
            onLongClickItem(adapterPosition)
            true
        }

        with(itemView.context.getScreenSize()) {
            width = first
        }
    }

    override fun bind(data: PickerMedia) {
        with(binding) {
            width = this@PickerItemViewHolder.width / 2
            height = this@PickerItemViewHolder.width / 2
        }
        super.bind(data)
    }
}