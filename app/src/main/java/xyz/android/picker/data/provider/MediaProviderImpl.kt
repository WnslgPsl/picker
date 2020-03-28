package xyz.android.picker.data.provider

import android.content.Context
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import xyz.android.picker.common.MediaStoreFileType
import xyz.android.picker.data.entity.PickerMediaEntity
import java.util.*
import javax.inject.Inject

class MediaProviderImpl @Inject constructor(private val context: Context) : MediaProvider {
    override fun provide(type: MediaStoreFileType): List<PickerMediaEntity> {

        val fileList = mutableListOf<PickerMediaEntity>()

        val date = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            MediaStore.Files.FileColumns.DATE_TAKEN
        } else {
            MediaStore.Files.FileColumns.DATE_TAKEN
        }

        val projection = arrayOf(
            MediaStore.Files.FileColumns._ID,
            MediaStore.Files.FileColumns.DISPLAY_NAME,
            date
        )

        val cursor = context.contentResolver.query(
            type.externalContentUri,
            projection,
            null,
            null,
            "$date DESC"
        )

        cursor?.use {
            val idColumn = it.getColumnIndexOrThrow(MediaStore.Files.FileColumns._ID)
            val dateTakenColumn =
                it.getColumnIndexOrThrow(date)
            val displayNameColumn =
                it.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DISPLAY_NAME)
            while (it.moveToNext()) {
                val id = it.getLong(idColumn)
                val dateTaken = Date(it.getLong(dateTakenColumn))
                val displayName = it.getString(displayNameColumn)
                val contentUri = Uri.withAppendedPath(
                    type.externalContentUri,
                    id.toString()
                )

                fileList.add(PickerMediaEntity(type, dateTaken, displayName, contentUri))
            }
        }
        return fileList
    }
}