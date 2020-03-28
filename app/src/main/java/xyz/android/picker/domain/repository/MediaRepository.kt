package xyz.android.picker.domain.repository

import io.reactivex.Flowable
import xyz.android.picker.common.MediaStoreFileType
import xyz.android.picker.common.Result
import xyz.android.picker.domain.model.PickerMedia

interface MediaRepository {

    fun getMedia(type: MediaStoreFileType) : Flowable<Result<List<PickerMedia>>>
}