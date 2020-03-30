package xyz.android.picker.presentation.ui.result

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import xyz.android.picker.R
import xyz.android.picker.databinding.ResultActivityViewBinding
import xyz.android.picker.presentation.base.ViewBindingActivity
import javax.inject.Inject

class ResultActivity : ViewBindingActivity<ResultActivityViewBinding, ResultViewModel>() {

    override fun getLayoutResId(): Int = R.layout.activity_result

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    override val viewModel: ResultViewModel
        get() = ViewModelProvider(this, viewModelFactory)[ResultViewModel::class.java]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
