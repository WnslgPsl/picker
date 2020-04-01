package xyz.android.picker.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import xyz.android.picker.databinding.PickerListItemViewBinding
import xyz.android.picker.presentation.model.PickerMedia

class PickerAdapter(
    private val onClickItem: (Int) -> Unit,
    private val onLongClickItem: (Int) -> Unit
) : ListAdapter<PickerMedia, PickerItemViewHolder>(PickerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PickerItemViewHolder {
        return PickerItemViewHolder(
            PickerListItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onClickItem, onLongClickItem
        )
    }

    override fun onBindViewHolder(holder: PickerItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PickerDiffCallback : DiffUtil.ItemCallback<PickerMedia>() {

    override fun areItemsTheSame(oldItem: PickerMedia, newItem: PickerMedia): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: PickerMedia, newItem: PickerMedia): Boolean =
        oldItem == newItem
}
