package xyz.android.picker.presentation.model

data class PickerMedia(
    val date: String,
    val uri: String,
    val isSelected: Boolean = false
)