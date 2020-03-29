package xyz.android.picker.presentation.model

import android.net.Uri
import xyz.android.picker.common.MediaStoreFileType
import java.util.*

data class PickerMedia(
    val id: Long,
    val type: MediaStoreFileType,
    val date: Date,
    val uri: Uri,
    val duration: Long?,
    var isSelected: Boolean = false
)