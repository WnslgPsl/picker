package xyz.android.picker.common.binding

import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import xyz.android.picker.R

@BindingAdapter("isBackground")
fun View.isSelectedBackground(isBackground: Boolean) {
    val color = if(isBackground) {
        ContextCompat.getColor(context, R.color.black80)
    }else{
        ContextCompat.getColor(context, android.R.color.transparent)
    }
    this.setBackgroundColor(color)
}
