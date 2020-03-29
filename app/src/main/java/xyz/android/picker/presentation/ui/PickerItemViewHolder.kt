package xyz.android.picker.presentation.ui

import androidx.recyclerview.widget.RecyclerView
import xyz.android.picker.databinding.PickerListItemViewBinding
import xyz.android.picker.presentation.model.PickerMedia

class PickerItemViewHolder(
    private val binding: PickerListItemViewBinding,
    onClickItem: (Int) -> Unit,
    onLongClickItem: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener {
            onClickItem(adapterPosition)
        }

        itemView.setOnLongClickListener {
            onLongClickItem(adapterPosition)
            true
        }
    }

    fun bind(item: PickerMedia) {
        with(binding) {
            this.item = item
            executePendingBindings()
        }
    }
}