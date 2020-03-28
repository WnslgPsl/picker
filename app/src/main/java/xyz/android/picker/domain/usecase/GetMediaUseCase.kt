package xyz.android.picker.domain.usecase

import io.reactivex.Flowable
import io.reactivex.rxkotlin.Flowables
import xyz.android.picker.common.Result
import xyz.android.picker.common.toErrorResult
import xyz.android.picker.common.toResult
import xyz.android.picker.presentation.model.PickerMedia
import javax.inject.Inject

class GetMediaUseCase @Inject constructor(
    private val getImageUseCase: GetImageUseCase,
    private val getVideoUseCase: GetVideoUseCase
) {

    operator fun invoke(): Flowable<Result<List<PickerMedia>>> {
        return Flowables.zip(
            getImageUseCase(),
            getVideoUseCase()
        ) { images, videos ->

            val imageList = when (images) {
                is Result.OnSuccess -> images.data
                is Result.OnError -> listOf()
            }

            val videoList = when (videos) {
                is Result.OnSuccess -> videos.data
                is Result.OnError -> listOf()
            }

            mutableListOf<PickerMedia>().apply {
                addAll(imageList)
                addAll(videoList)
                sortBy {
                    it.date
                }
            }.toList().toResult()

        }.onErrorReturn {
            it.toErrorResult()
        }
    }
}