package xyz.android.picker.domain.usecase

import io.reactivex.Flowable
import xyz.android.picker.common.MediaStoreFileType
import xyz.android.picker.common.Result
import xyz.android.picker.domain.model.PickerMedia
import xyz.android.picker.domain.repository.MediaRepository
import javax.inject.Inject

class GetVideoUseCase @Inject constructor(private val repository: MediaRepository) {

    operator fun invoke(): Flowable<Result<List<PickerMedia>>> {
        return repository.getMedia(MediaStoreFileType.VIDEO)
    }
}