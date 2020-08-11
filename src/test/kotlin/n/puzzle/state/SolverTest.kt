package n.puzzle.state

import org.junit.Assert.*
import org.junit.Test

class SolverTest {

    @ExperimentalUnsignedTypes
    @Test
    fun testAStartSearchManhattan() {

        val expectedArray = UIntArray(9) { if (it != 8) it.toUInt() + 1u else 0U }
        //{1,3,5,4,0,2,7,8,6} 6 step solution

        expectedArray[0] = 1u
        expectedArray[1] = 3u
        expectedArray[2] = 5u
        expectedArray[3] = 4u
        expectedArray[4] = 0u
        expectedArray[5] = 2u
        expectedArray[6] = 7u
        expectedArray[7] = 8u
        expectedArray[8] = 6u

        val solver = Solver(State(expectedArray, 3))

        solver.AStarSolve()
    }

}