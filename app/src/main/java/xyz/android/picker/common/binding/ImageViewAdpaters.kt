package xyz.android.picker.common.binding

import android.net.Uri
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import xyz.android.picker.R
import xyz.android.picker.common.REQUEST_HEIGHT
import xyz.android.picker.common.REQUEST_WIDTH

@BindingAdapter(value = ["loadImageUri"])
fun ImageView.setImageLoaded(uri: Uri?) {
    uri?.let {
        Glide
            .with(context)
            .load(it)
            .override(REQUEST_WIDTH, REQUEST_HEIGHT)
            .error(R.drawable.ic_play_arrow_white_16dp)
            .centerCrop()
            .into(this)
    }
}

@BindingAdapter("isSelected")
fun ImageView.setCheckBoxBackground(isSelected: Boolean) {
    val drawable = if(isSelected) {
        ContextCompat.getDrawable(context, R.drawable.ic_check_circle_white_24dp)
    }else{
        ContextCompat.getDrawable(context, R.drawable.ic_radio_button_unchecked_white_24dp)
    }

    this.background = drawable
}