package xyz.android.picker.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import xyz.android.picker.databinding.PickerListItemViewBinding
import xyz.android.picker.presentation.model.PickerMedia

class PickerAdapter(
    private val onClickItem: (Int) -> Unit,
    private val onLongClickItem: (Int) -> Unit
) :
    RecyclerView.Adapter<PickerItemViewHolder>() {

    private var items: MutableList<PickerMedia> = mutableListOf()

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
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun loadItems(newItems: List<PickerMedia>) {
        this.items.clear()
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun updateItem(item: PickerMedia, position: Int) {
        this.items[position] = item
        notifyItemChanged(position)
    }

}
