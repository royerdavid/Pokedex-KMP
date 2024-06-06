package royerdavid.pokedex.core.util

/**
 * Returns a new [List] filled with all elements plus the new item.
 * Consecutive messages with same content are ignored.
 */
fun List<String>.copyEnqueue(item: String): List<String> {
    val newList = toMutableList()
    if (lastOrNull() != item) {
        newList.add(item)
    }
    return newList
}

/**
 * Returns a new [List] filled with all elements except the first one.
 */
fun List<String>.copyDequeue(): List<String> {
    return toMutableList().apply {
        removeFirstOrNull()
    }
}
