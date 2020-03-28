package xyz.android.picker.common

sealed class Result<out T> {
    data class OnSuccess<out T>(val data: T) : Result<T>()
    data class OnError<out T>(val error: Error) : Result<T>()
}

data class Error(
    val code: Int,
    val message: String? = null,
    val cause: Throwable? = null
)

class ErrorThrowable(
    val code: Int,
    override val message: String? = null,
    private val throwable: Throwable? = null
) : Throwable(message) {
    fun toError() = Error(code, message, throwable)
}

fun Error.toThrowable(): ErrorThrowable {
    return ErrorThrowable(code, message, cause)
}

fun <T> Error.toResult(): Result<T> {
    return Result.OnError(this)
}

fun <T> Throwable.toErrorResult(): Result<T> {
    return when (this) {
        is ErrorThrowable -> Result.OnError(toError())
        else -> Result.OnError(ErrorThrowable(UNKNOWN, message, this).toError())
    }
}

fun <T> T.toResult(): Result<T> {
    return Result.OnSuccess(this)
}

// unknown error
const val UNKNOWN = 99000