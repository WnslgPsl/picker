package xyz.android.picker.presentation.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import xyz.android.picker.common.MediaStoreFileType
import java.util.*

@Parcelize
data class PickerMedia(
    val id: Long,
    val type: MediaStoreFileType,
    val date: Date,
    val uri: Uri,
    val duration: Long?,
    var isSelected: Boolean = false
) : Parcelable