package xyz.android.picker.data.provider

import xyz.android.picker.common.MediaStoreFileType
import xyz.android.picker.data.entity.PickerMediaEntity

interface MediaProvider {
    fun provide(type: MediaStoreFileType): List<PickerMediaEntity>
}