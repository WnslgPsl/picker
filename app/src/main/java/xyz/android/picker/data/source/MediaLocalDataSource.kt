package xyz.android.picker.data.source

import io.reactivex.Flowable
import xyz.android.picker.common.MediaStoreFileType
import xyz.android.picker.common.Result
import xyz.android.picker.presentation.model.PickerMedia
import javax.inject.Inject

class MediaLocalDataSource @Inject constructor() : MediaDataSource {
    override fun getMedia(type: MediaStoreFileType): Flowable<Result<List<PickerMedia>>> {
        return Flowable.never()
    }
}