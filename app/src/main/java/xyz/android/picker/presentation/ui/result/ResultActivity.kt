package xyz.android.picker.presentation.ui.result

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_result.*
import xyz.android.picker.R
import xyz.android.picker.common.RESULT_ITEM_EXTRA
import xyz.android.picker.databinding.ResultActivityViewBinding
import xyz.android.picker.presentation.base.ViewBindingActivity
import xyz.android.picker.presentation.model.PickerMedia
import javax.inject.Inject

class ResultActivity : ViewBindingActivity<ResultActivityViewBinding, ResultViewModel>() {

    override fun getLayoutResId(): Int = R.layout.activity_result

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    override val viewModel: ResultViewModel
        get() = ViewModelProvider(this, viewModelFactory)[ResultViewModel::class.java]

    private val adapter: ResultAdapter by lazy {
        ResultAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val items: List<PickerMedia> =
            intent.extras?.getParcelableArrayList(RESULT_ITEM_EXTRA) ?: emptyList()

        with(rvResult) {
            layoutManager = LinearLayoutManager(this@ResultActivity)
            adapter = this@ResultActivity.adapter
        }

        adapter.loadItems(items.toMutableList())
    }
}
