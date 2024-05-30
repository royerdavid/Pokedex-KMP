package royerdavid.pokedex.core.util

sealed class Resource<T>(val data: T? = null, val exception: Throwable? = null) {
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(exception: Throwable, data: T? = null) : Resource<T>(data, exception)
}
