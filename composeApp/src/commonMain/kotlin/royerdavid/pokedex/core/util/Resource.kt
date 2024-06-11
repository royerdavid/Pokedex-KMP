package royerdavid.pokedex.core.util

sealed class Resource<T> {
    class Success<T>(val data: T? = null) : Resource<T>()
    class Error<T>(val exception: Throwable? = null) : Resource<T>()
    class Loading<T>(val isLoading: Boolean = true) : Resource<T>()
}
