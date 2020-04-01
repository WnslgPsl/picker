package xyz.android.picker.presentation.ui

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
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

    private val _actionVideo = MutableLiveData<Event<Uri>>()
    val actionVideo: LiveData<Event<Uri>> get() = _actionVideo

    private val _moveToPreview = MutableLiveData<Event<Unit>>()
    val moveToPreview: LiveData<Event<Unit>> get() = _moveToPreview

    private val _confirm = MutableLiveData<Event<Unit>>()

    val moveToResult: LiveData<List<PickerMedia>> = Transformations.map(_confirm) {
        selectedItemMap.map {
            it.value
        }
    }

    val selectedCount: LiveData<Int> = Transformations.map(mediaItems) {
        it?.filter { pickerMedia ->
            pickerMedia.isSelected
        }?.count()
    }

    var previewUri: Uri? = null
        private set

    private val selectedItemMap = LinkedHashMap<Long, PickerMedia>()

    fun init() {
        getMediaUseCase()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                when (it) {
                    is Result.OnSuccess -> {
                        _mediaItems.value = it.data.toMutableList()
                    }
                    is Result.OnError -> {
                        _toast.value = Event(R.string.default_error)
                    }
                }
            }.addTo(compositeDisposable)
    }

    fun onClickConfirm() {
        _confirm.value = Event(Unit)
    }

    fun onClickItem(position: Int) {
        val items = (_mediaItems.value as MutableList).toMutableList()
        val pickerMedia = items[position].copy()
        pickerMedia.isSelected = !pickerMedia.isSelected
        items[position] = pickerMedia
        if (items[position].isSelected) {
            selectedItemMap[items[position].id] = items[position]
        } else {
            selectedItemMap.remove(items[position].id)
        }
        _mediaItems.value = items
    }

    fun onLongClickItem(position: Int) {
        _mediaItems.value?.let {
            val item = it[position]
            if (item.type == MediaStoreFileType.VIDEO) {
                _actionVideo.value = Event(item.uri)
            } else {
                previewUri = item.uri
                _moveToPreview.value = Event(Unit)
            }
        }
    }

}