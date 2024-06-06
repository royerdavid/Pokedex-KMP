package royerdavid.pokedex.core.util

/**
 * Returns a new [List] filled with all elements plus the new item.
 * Consecutive messages with same content are ignored.
 */
fun List<String>.copyEnqueue(item: String): List<String> =
    toMutableList().apply {
        add(item)
    }
