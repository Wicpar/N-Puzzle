package n.puzzle.heuristics

import n.puzzle.state.Coord
import n.puzzle.state.State
import kotlin.math.sqrt

@ExperimentalUnsignedTypes
object Euclidean: Heuristic {

    private fun euclideanDst(a: Coord, b: Coord) =
        sqrt(
            Math.pow(
                (a.x - b.x).toDouble(),
                2.0
            ) + Math.pow((a.y - b.y).toDouble(), 2.0)
        )

    override fun heuristic(state: State, naturalOrder: NaturalOrder, pos: Coord, value: UInt): Double {
        return euclideanDst(pos, naturalOrder.getNaturalIndex(value)!!)
    }
}
