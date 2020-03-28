package xyz.android.picker.presentation.ui

import android.os.Bundle
import xyz.android.picker.R
import xyz.android.picker.databinding.PickerActivityBinding
import xyz.android.picker.presentation.base.ViewBindingActivity

class PickerActivity : ViewBindingActivity<PickerActivityBinding, PickerViewModel>() {

    override fun getLayoutResId(): Int = R.layout.activity_picker

    override val viewModel: PickerViewModel
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
