package royerdavid.pokedex.core.util

fun <T> List<T>.copyEnqueueDistinct(item: T): List<T> {
    /**
     * Returns a new [List] with the new item queued if it isn't already present. If present, the
     * original list is returned.
     */
    return if (this.contains(item)) {
        this
    } else
        toMutableList().apply {
            add(item)
        }
}
