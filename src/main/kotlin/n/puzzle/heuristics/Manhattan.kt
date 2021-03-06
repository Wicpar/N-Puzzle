package n.puzzle.heuristics

import n.puzzle.state.Coord
import n.puzzle.state.State
import kotlin.math.abs

@ExperimentalUnsignedTypes
object Manhattan: Heuristic {

    private fun manhattanDst(a: Coord, b: Coord) = abs(a.x - b.x) + abs(a.y - b.y)

    override fun heuristic(state: State, naturalOrder: NaturalOrder, pos: Coord, value: UInt): Double {
        return manhattanDst(pos, naturalOrder.getNaturalIndex(value)!!).toDouble()
    }
}

