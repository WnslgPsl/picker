package xyz.android.picker.data.repository

import io.reactivex.Flowable
import xyz.android.picker.common.MediaStoreFileType
import xyz.android.picker.common.Result
import xyz.android.picker.data.source.MediaLocalDataSource
import xyz.android.picker.data.source.MediaRemoteDataSource
import xyz.android.picker.domain.repository.MediaRepository
import xyz.android.picker.presentation.model.PickerMedia
import javax.inject.Inject

class MediaRepositoryImpl @Inject constructor(
    private val local: MediaLocalDataSource,
    private val remote: MediaRemoteDataSource
) : MediaRepository {

    override fun getMedia(type: MediaStoreFileType): Flowable<Result<List<PickerMedia>>> {
        return local.getMedia(type)
    }
}