package n.puzzle.state

import n.puzzle.heuristics.NaturalOrder
import n.puzzle.heuristics.manhattan
import org.junit.Assert.*
import org.junit.Test

class SearchTest {

    @ExperimentalUnsignedTypes
    @Test
    fun testAStartSearchManhattan() {

        val expectedArray = UIntArray(9) { if (it != 8) it.toUInt() + 1u else 0U }

        research = Search(State(expectedArray, 3), )
    }

}