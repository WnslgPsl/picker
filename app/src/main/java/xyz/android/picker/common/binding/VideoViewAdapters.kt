package xyz.android.picker.common.binding

import android.net.Uri
import android.widget.VideoView
import androidx.databinding.BindingAdapter

@BindingAdapter("loadVideo")
fun VideoView.loadVideo(uri: Uri?) {
    uri?.let {
        postDelayed({
            setVideoURI(it)
        }, 100)
    }
}