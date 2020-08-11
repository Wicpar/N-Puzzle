package n.puzzle.state

import n.puzzle.heuristics.Manhattan
import n.puzzle.heuristics.NaturalOrder
import org.junit.Test

class StateTest {

    @ExperimentalUnsignedTypes
    @Test
    fun testHeuristic() {
        println(NaturalOrder[4].state.neighborsWithHeuristic(Manhattan))
    }

}
