package royerdavid.pokedex.core.data

sealed class DataResult<out S, out E> {
    class Success<out S>(val data: S) : DataResult<S, Nothing>()
    class Error<out E>(val error: E) : DataResult<Nothing, E>()
    class Loading(val isLoading: Boolean = true) : DataResult<Nothing, Nothing>()
}
