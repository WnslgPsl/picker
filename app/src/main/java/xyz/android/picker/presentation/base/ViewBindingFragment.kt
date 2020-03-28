package xyz.android.picker.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import xyz.android.picker.BR
import xyz.android.picker.common.observeEvent

abstract class ViewBindingFragment<B : ViewDataBinding, VM : BaseViewModel> : BaseFragment() {

    protected abstract val viewModel: VM
    protected lateinit var viewDataBinding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        return viewDataBinding.run {
            lifecycleOwner = this@ViewBindingFragment
            setVariable(BR.viewModel, viewModel)
            root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.toast.observeEvent(this) {
            Toast.makeText(context, getString(it), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewDataBinding.unbind()
    }

}