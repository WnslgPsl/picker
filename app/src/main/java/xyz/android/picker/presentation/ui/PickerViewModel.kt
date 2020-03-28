package xyz.android.picker.presentation.ui

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import xyz.android.picker.R
import xyz.android.picker.common.Event
import xyz.android.picker.common.Result
import xyz.android.picker.domain.usecase.GetMediaUseCase
import xyz.android.picker.presentation.base.BaseViewModel
import javax.inject.Inject

class PickerViewModel @Inject constructor(
    private val getMediaUseCase: GetMediaUseCase
) : BaseViewModel() {

    fun init() {
        getMediaUseCase()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                when(it) {
                    is Result.OnSuccess -> {
                        it.data.forEach {
                        }
                    }
                    is Result.OnError -> {
                        _toast.value = Event(R.string.default_error)
                    }
                }
            }.addTo(compositeDisposable)
    }
}