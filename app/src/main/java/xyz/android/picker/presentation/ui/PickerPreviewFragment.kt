package xyz.android.picker.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.picker_preview_fragment.*
import xyz.android.picker.R
import xyz.android.picker.databinding.PickerPreviewViewBinding
import xyz.android.picker.presentation.base.ViewBindingFragment
import javax.inject.Inject

class PickerPreviewFragment : ViewBindingFragment<PickerPreviewViewBinding, PickerViewModel>() {

    override fun getLayoutResId(): Int = R.layout.picker_preview_fragment

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    override val viewModel: PickerViewModel
        get() = ViewModelProvider(requireActivity(), viewModelFactory)[PickerViewModel::class.java]


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.previewUri?.let {
            Glide.with(this)
                .load(it)
                .fitCenter()
                .into(ivPreview)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PickerPreviewFragment()
    }
}