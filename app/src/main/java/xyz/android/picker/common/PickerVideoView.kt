package xyz.android.picker.common

import android.content.Context
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.util.AttributeSet
import android.widget.VideoView


class PickerVideoView @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    VideoView(context, attrs, defStyleAttr) {

    private var videoWidth: Int = 0
    private var videoHeight: Int = 0


    override fun setVideoURI(uri: Uri?) {

        val retriever = MediaMetadataRetriever()
        retriever.setDataSource(this.context, uri)
        videoWidth =
            Integer.parseInt(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH))
        videoHeight =
            Integer.parseInt(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT))
        super.setVideoURI(uri)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        var width: Int = getDefaultSize(videoWidth, widthMeasureSpec)
        var height: Int = getDefaultSize(videoHeight, heightMeasureSpec)

        val isVideoVertical = videoHeight > videoWidth

        if (isVideoVertical) {
            width = (videoWidth * (height.toFloat() / videoHeight.toFloat())).toInt()
        } else {
            val temp = videoWidth
            videoWidth = videoHeight
            videoHeight = temp

            height = (videoHeight * (width.toFloat() / videoWidth.toFloat())).toInt()
        }
        setMeasuredDimension(width, height)
    }
}