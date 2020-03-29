package xyz.android.picker.common.binding

fun Long.convertSecondsToHMmSs(): String? {

    val second = this/1000

    val hours   = (second / 3600).toInt()
    val minutes = ((second - (hours * 3600)) / 60).toInt()
    val seconds = (second - (hours * 3600) - (minutes * 60)).toInt()

    return if(hours > 0) {
        String.format("%d:%02d:%02d", hours, minutes, seconds)
    }else{
        String.format("%d:%02d", minutes, seconds)
    }

}