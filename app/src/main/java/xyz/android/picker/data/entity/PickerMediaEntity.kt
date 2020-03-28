package xyz.android.picker.data.entity

import android.net.Uri
import xyz.android.picker.common.MediaStoreFileType
import java.util.*

data class PickerMediaEntity(
    val type: MediaStoreFileType,
    val date: Date,
    val displayName: String,
    val uri: Uri
)