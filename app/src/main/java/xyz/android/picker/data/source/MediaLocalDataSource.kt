package xyz.android.picker.data.source

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import xyz.android.picker.common.MediaStoreFileType
import xyz.android.picker.common.Result
import xyz.android.picker.common.toResult
import xyz.android.picker.data.mapper.PickerMediaMapper
import xyz.android.picker.data.provider.MediaProvider
import xyz.android.picker.presentation.model.PickerMedia
import javax.inject.Inject

class MediaLocalDataSource @Inject constructor(
    private val mapper: PickerMediaMapper,
    private val mediaProvider: MediaProvider
) : MediaDataSource {
    override fun getMedia(type: MediaStoreFileType): Flowable<Result<List<PickerMedia>>> {

        return Flowable.fromCallable {
            mediaProvider.provide(type)
        }.subscribeOn(Schedulers.io()).map {
            mapper.mapFromEntity(it).toResult()
        }.onErrorReturn {
            emptyList<PickerMedia>().toResult()
        }
    }
}