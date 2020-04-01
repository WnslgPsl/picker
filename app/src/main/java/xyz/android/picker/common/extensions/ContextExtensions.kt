package xyz.android.picker.common.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Point

fun Context.getScreenSize(): Pair<Int, Int> {
    val display = (this as Activity).windowManager.defaultDisplay
    val size = Point()
    display.getSize(size)
    return Pair(size.x, size.y)
}
