package xyz.android.picker.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import xyz.android.picker.common.Event

open class BaseViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()

    protected val _toast = MutableLiveData<Event<Int>>()
    val toast: LiveData<Event<Int>> get() = _toast

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}