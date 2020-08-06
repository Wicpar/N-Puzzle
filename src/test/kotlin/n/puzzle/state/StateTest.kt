package n.puzzle.state

import n.puzzle.heuristics.NaturalOrder
import n.puzzle.heuristics.manhattan
import org.junit.Assert.*
import org.junit.Test

class StateTest {

    @ExperimentalUnsignedTypes
    @Test
    fun testHeuristic() {
        println(NaturalOrder[4].state.bestCoord(State::manhattan))
    }

}
