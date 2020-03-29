package xyz.android.picker.presentation.ui

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import xyz.android.picker.R
import xyz.android.picker.common.Event
import xyz.android.picker.common.MediaStoreFileType
import xyz.android.picker.common.Result
import xyz.android.picker.domain.usecase.GetMediaUseCase
import xyz.android.picker.presentation.base.BaseViewModel
import xyz.android.picker.presentation.model.PickerMedia
import javax.inject.Inject

class PickerViewModel @Inject constructor(
    private val getMediaUseCase: GetMediaUseCase
) : BaseViewModel() {

    private val _mediaItems = MutableLiveData<List<PickerMedia>>()
    val mediaItems: LiveData<List<PickerMedia>> get() = _mediaItems

    private val _updateItem = MutableLiveData<Pair<PickerMedia, Int>>()
    val updateItem: LiveData<Pair<PickerMedia, Int>> get() = _updateItem

    private val _actionVideo = MutableLiveData<Event<Uri>>()
    val actionVideo: LiveData<Event<Uri>> get() = _actionVideo

    private val _moveToPreviewImage = MutableLiveData<Event<Uri>>()
    val moveToPreviewImage: LiveData<Event<Uri>> get() = _moveToPreviewImage

    fun init() {
        getMediaUseCase()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                when (it) {
                    is Result.OnSuccess -> {
                        _mediaItems.value = it.data
                    }
                    is Result.OnError -> {
                        _toast.value = Event(R.string.default_error)
                    }
                }
            }.addTo(compositeDisposable)
    }

    fun onClickItem(position: Int) {
        _mediaItems.value?.let {
            it[position].isSelected = !it[position].isSelected
            _updateItem.value = Pair(it[position], position)
        }
    }

    fun onLongClickItem(position: Int) {
        _mediaItems.value?.let {
            val item = it[position]
            if(item.type == MediaStoreFileType.VIDEO){
                _actionVideo.value = Event(item.uri)
            }else{
                _moveToPreviewImage.value = Event(item.uri)
            }
        }
    }

}