package xyz.android.picker.presentation.ui

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
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

        TedPermission.with(this)
            .setPermissionListener(permissionListener)
            .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
            .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
            .check();
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
