package n.puzzle.heuristics

import n.puzzle.state.Coord
import n.puzzle.state.State
import kotlin.math.abs

/**
 * Real garbage, has to be changed to something more sensible
 */
@ExperimentalUnsignedTypes
object Hamming: Heuristic {

    override fun heuristic(state: State, naturalOrder: NaturalOrder, pos: Coord, value: UInt): Double {
        return abs(value.toDouble() - naturalOrder.state[pos].toDouble())
    }
}
