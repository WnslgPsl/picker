package xyz.android.picker.data.mapper

import xyz.android.picker.data.entity.PickerMediaEntity
import xyz.android.picker.presentation.model.PickerMedia
import javax.inject.Inject

class PickerMediaMapper @Inject constructor() : Mapper<List<PickerMediaEntity>, List<PickerMedia>> {
    override fun mapFromEntity(entity: List<PickerMediaEntity>): List<PickerMedia> {
        return entity.map {
            with(it) {
                PickerMedia(
                    date = date,
                    uri = uri
                )
            }
        }
    }
}