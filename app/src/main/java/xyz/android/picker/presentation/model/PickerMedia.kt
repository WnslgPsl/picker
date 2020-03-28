package xyz.android.picker.presentation.model

import android.net.Uri
import xyz.android.picker.common.MediaStoreFileType
import java.util.*

data class PickerMedia(
    val type: MediaStoreFileType,
    val date: Date,
    val uri: Uri,
    val isSelected: Boolean = false
)