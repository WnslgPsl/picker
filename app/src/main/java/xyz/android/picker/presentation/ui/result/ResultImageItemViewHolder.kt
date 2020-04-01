package xyz.android.picker.presentation.ui.result

import xyz.android.picker.common.extensions.getScreenSize
import xyz.android.picker.databinding.ResultImageItemViewBinding
import xyz.android.picker.presentation.base.BaseBindingViewHolder
import xyz.android.picker.presentation.model.PickerMedia

class ResultImageItemViewHolder(
    binding: ResultImageItemViewBinding
): BaseBindingViewHolder<PickerMedia, ResultImageItemViewBinding>(binding) {

    var width: Int

    init {
        with(itemView.context.getScreenSize()) {
            width = first
        }
    }

    override fun bind(data: PickerMedia) {
        with(binding) {
            width = this@ResultImageItemViewHolder.width
            height = this@ResultImageItemViewHolder.width
        }
        super.bind(data)
    }
}