package xyz.android.picker.presentation.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import xyz.android.picker.R
import xyz.android.picker.databinding.PickerActivityBinding
import xyz.android.picker.presentation.base.ViewBindingActivity
import javax.inject.Inject

class PickerActivity : ViewBindingActivity<PickerActivityBinding, PickerViewModel>() {

    override fun getLayoutResId(): Int = R.layout.activity_picker

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    override val viewModel: PickerViewModel
        get() =  ViewModelProvider(this, viewModelFactory)[PickerViewModel::class.java]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
