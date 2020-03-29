package xyz.android.picker.common

import android.net.Uri
import android.provider.MediaStore

enum class MediaStoreFileType(
    val externalContentUri: Uri
) {
    IMAGE(MediaStore.Images.Media.EXTERNAL_CONTENT_URI),
    VIDEO(MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
}