package n.puzzle.heuristics

import org.junit.Test

import org.junit.Assert.*

class NaturalOrderTest {

    @ExperimentalUnsignedTypes
    @Test
    fun getState() {
        val res = """
             1  2  3  4
            12 13 14  5
            11  0 15  6
            10  9  8  7
        """.trimIndent()

        assertEquals(res, NaturalOrder(4).state.toString())

    }
}
