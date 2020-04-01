package xyz.android.picker.presentation.ui.result

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.result_video_item.view.*
import xyz.android.picker.common.MediaStoreFileType
import xyz.android.picker.databinding.ResultImageItemViewBinding
import xyz.android.picker.databinding.ResultVideoItemViewBinding
import xyz.android.picker.presentation.base.BaseBindingViewHolder
import xyz.android.picker.presentation.base.BaseRecyclerViewAdapter
import xyz.android.picker.presentation.model.PickerMedia

private const val IMAGE_TYPE = 1
private const val VIDEO_TYPE = 2

class ResultAdapter :
    BaseRecyclerViewAdapter<PickerMedia, BaseBindingViewHolder<PickerMedia, ViewDataBinding>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseBindingViewHolder<PickerMedia, ViewDataBinding> {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            IMAGE_TYPE -> ResultImageItemViewHolder(
                ResultImageItemViewBinding.inflate(inflater, parent, false)
            )
            VIDEO_TYPE -> ResultVideoItemViewHolder(
                ResultVideoItemViewBinding.inflate(inflater, parent, false)
            )
            else -> throw IllegalAccessException("unknown view type!!!!")
        }
    }

    override fun onBindViewHolder(holder: BaseBindingViewHolder<PickerMedia, ViewDataBinding>, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).type) {
            MediaStoreFileType.IMAGE -> IMAGE_TYPE
            MediaStoreFileType.VIDEO -> VIDEO_TYPE
        }
    }

    override fun onViewAttachedToWindow(holder: BaseBindingViewHolder<PickerMedia, ViewDataBinding>) {
        super.onViewAttachedToWindow(holder)
        if (holder is ResultVideoItemViewHolder) {
            holder.itemView.videoView.setOnPreparedListener {
                holder.itemView.videoView.start()
            }
        }
    }

    override fun onViewDetachedFromWindow(holder: BaseBindingViewHolder<PickerMedia, ViewDataBinding>) {
        if (holder is ResultVideoItemViewHolder) {
            holder.itemView.videoView.pause()
        }
        super.onViewDetachedFromWindow(holder)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        val childCount = recyclerView.childCount
        for (i in 0 until childCount) {
            val holder =
                recyclerView.findViewHolderForAdapterPosition(i)

            if (holder is ResultVideoItemViewHolder) {
                if (holder.itemView.videoView != null) {
                    holder.itemView.videoView.stopPlayback()
                }
            }
        }
        super.onDetachedFromRecyclerView(recyclerView)
    }
}