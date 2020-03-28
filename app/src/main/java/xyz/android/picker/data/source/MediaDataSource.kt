package xyz.android.picker.data.source

import io.reactivex.Flowable
import xyz.android.picker.common.MediaStoreFileType
import xyz.android.picker.common.Result
import xyz.android.picker.presentation.model.PickerMedia

interface MediaDataSource {

    fun getMedia(type: MediaStoreFileType) : Flowable<Result<List<PickerMedia>>>
}