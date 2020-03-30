package xyz.android.picker.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.picker_fragment.*
import xyz.android.picker.R
import xyz.android.picker.common.GRID_LAYOUT_COUNT
import xyz.android.picker.common.observe
import xyz.android.picker.databinding.PickerFragmentViewBinding
import xyz.android.picker.presentation.base.ViewBindingFragment
import javax.inject.Inject

class PickerFragment : ViewBindingFragment<PickerFragmentViewBinding, PickerViewModel>() {

    override fun getLayoutResId(): Int = R.layout.picker_fragment

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    override val viewModel: PickerViewModel
        get() = ViewModelProvider(requireActivity(), viewModelFactory)[PickerViewModel::class.java]

    private val adapter: PickerAdapter by lazy {
        PickerAdapter(viewModel::onClickItem, viewModel::onLongClickItem)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(rvPicker) {
            layoutManager = GridLayoutManager(context, GRID_LAYOUT_COUNT)
            adapter = this@PickerFragment.adapter
            itemAnimator = null
        }

        viewModel.mediaItems.observe(this) {
            adapter.loadItems(it)
        }

        viewModel.updateItem.observe(this) {
            val (item, position) = it
            adapter.updateItem(item, position)
        }
    }
}