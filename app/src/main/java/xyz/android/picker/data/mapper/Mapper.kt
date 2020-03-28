package xyz.android.picker.data.mapper

interface Mapper<in T1, out T2> {
    fun mapFromEntity(entity: T1): T2
}