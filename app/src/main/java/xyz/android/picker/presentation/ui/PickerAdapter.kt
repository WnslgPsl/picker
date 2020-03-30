package xyz.android.picker.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import xyz.android.picker.databinding.PickerListItemViewBinding
import xyz.android.picker.presentation.base.BaseRecyclerViewAdapter
import xyz.android.picker.presentation.model.PickerMedia

class PickerAdapter(
    private val onClickItem: (Int) -> Unit,
    private val onLongClickItem: (Int) -> Unit
) : BaseRecyclerViewAdapter<PickerMedia, PickerItemViewHolder>() {

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
