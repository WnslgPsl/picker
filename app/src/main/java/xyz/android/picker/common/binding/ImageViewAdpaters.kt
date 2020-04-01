package xyz.android.picker.common.binding

import android.net.Uri
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import xyz.android.picker.R


@BindingAdapter(value = ["loadImageUri", "widthSize", "heightSize"])
fun ImageView.setImageLoaded(uri: Uri?, widthSize: Int, heightSize: Int) {

    uri?.let {
        Glide
            .with(context)
            .load(it)
            .override(widthSize, heightSize)
            .error(R.drawable.ic_error_outline_white_24dp)
            .centerCrop()
            .into(this)
    }
}

@BindingAdapter("isSelected")
fun ImageView.setCheckBoxBackground(isSelected: Boolean) {
    this.background = if (isSelected) {
        ContextCompat.getDrawable(context, R.drawable.ic_check_circle_white_24dp)
    } else {
        ContextCompat.getDrawable(context, R.drawable.ic_radio_button_unchecked_white_24dp)
    }
}