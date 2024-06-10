package royerdavid.pokedex.core.util

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class CollectionUtilTest {

    @Test
    fun `'copyEnqueueDistinct' should append item to queue when different`() {
        assertContentEquals(
            listOf("a", "b", "c"),
            listOf("a", "b").copyEnqueueDistinct("c")
        )

        assertContentEquals(
            listOf(1, 2, 3),
            listOf(1, 2).copyEnqueueDistinct(3)
        )
    }

    @Test
    fun `'copyEnqueueDistinct' should return same list when item already exist in queue`() {
        assertEquals(
            listOf("a", "b"),
            listOf("a", "b").copyEnqueueDistinct("a")
        )

        assertEquals(
            listOf(1, 2),
            listOf(1, 2).copyEnqueueDistinct(1)
        )
    }
}
