package xyz.android.picker.presentation.base

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import xyz.android.picker.common.observeEvent
import xyz.android.picker.BR

abstract class ViewBindingActivity<B : ViewDataBinding, VM : BaseViewModel> : BaseActivity(){

    protected abstract val viewModel: VM
    protected lateinit var viewDataBinding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutResId())
        with(viewDataBinding) {
            lifecycleOwner = this@ViewBindingActivity
            setVariable(BR.viewModel, viewModel)
        }

        viewModel.toast.observeEvent(this) {
            Toast.makeText(this@ViewBindingActivity, getString(it), Toast.LENGTH_SHORT).show()
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        viewDataBinding.unbind()
    }
}