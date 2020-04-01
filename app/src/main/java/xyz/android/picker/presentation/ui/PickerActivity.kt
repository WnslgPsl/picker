package xyz.android.picker.presentation.ui

import android.Manifest
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.util.LruCache
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import xyz.android.picker.R
import xyz.android.picker.common.RESULT_ITEM_EXTRA
import xyz.android.picker.common.extensions.replaceFragment
import xyz.android.picker.common.extensions.replaceFragmentWithBackStack
import xyz.android.picker.common.observe
import xyz.android.picker.common.observeEvent
import xyz.android.picker.databinding.PickerActivityBinding
import xyz.android.picker.presentation.base.ViewBindingActivity
import xyz.android.picker.presentation.model.PickerMedia
import xyz.android.picker.presentation.ui.result.ResultActivity
import javax.inject.Inject

class PickerActivity : ViewBindingActivity<PickerActivityBinding, PickerViewModel>() {

    override fun getLayoutResId(): Int = R.layout.activity_picker

    private lateinit var memoryCache: LruCache<String, Bitmap>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    override val viewModel: PickerViewModel
        get() = ViewModelProvider(this, viewModelFactory)[PickerViewModel::class.java]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        replaceFragment(R.id.container, PickerFragment())

        TedPermission.with(this)
            .setPermissionListener(permissionListener)
            .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
            .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
            .check()

        viewModel.moveToPreview.observeEvent(this) {
            replaceFragmentWithBackStack(
                R.id.container,
                PickerPreviewFragment.newInstance()
            )
        }

        viewModel.moveToResult.observe(this) {
            with(Intent(this@PickerActivity, ResultActivity::class.java)) {
                putParcelableArrayListExtra(RESULT_ITEM_EXTRA, it as ArrayList<PickerMedia>)
                startActivity(this)
            }
        }

        viewModel.actionVideo.observeEvent(this) {
            startActivity(Intent(Intent.ACTION_VIEW, it))
        }
    }

    private val permissionListener: PermissionListener = object : PermissionListener {
        override fun onPermissionGranted() {
            viewModel.init()
        }

        override fun onPermissionDenied(deniedPermissions: List<String>) {
            Toast.makeText(
                this@PickerActivity,
                "Permission Denied\n$deniedPermissions",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
