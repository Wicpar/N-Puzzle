package n.puzzle.heuristics

import n.puzzle.state.Coord
import n.puzzle.state.State

/**
 * []heuristic] must be linear as to be addable
 */
@ExperimentalUnsignedTypes
interface Heuristic {
    fun heuristic(state: State, naturalOrder: NaturalOrder, pos: Coord, value: UInt): Double

    /**
     * Absolute progression from before state to after state must be linear
     */
    fun relativeHeuristic(state: State, naturalOrder: NaturalOrder, pos: Coord, value: UInt): Double {
        return heuristic(state, naturalOrder, state.zero, value) - heuristic(state, naturalOrder, pos, value)
    }
}

@ExperimentalUnsignedTypes
class WeightedHeuristic(val heuristic: Heuristic, val weight: Double): Heuristic {
    override fun heuristic(state: State, naturalOrder: NaturalOrder, pos: Coord, value: UInt): Double {
        return heuristic.heuristic(state, naturalOrder, pos, value) * weight
    }

}

@ExperimentalUnsignedTypes
class CombinedHeuristics(val a: Heuristic, val b: Heuristic): Heuristic {
    override fun heuristic(state: State, naturalOrder: NaturalOrder, pos: Coord, value: UInt): Double {
        return a.heuristic(state, naturalOrder, pos, value) + b.heuristic(state, naturalOrder, pos, value)
    }
}

@ExperimentalUnsignedTypes
operator fun Heuristic.plus(heuristic: Heuristic): Heuristic {
    return CombinedHeuristics(this, heuristic)
}

@ExperimentalUnsignedTypes
operator fun Heuristic.times(number: Number): Heuristic {
    return WeightedHeuristic(this, number.toDouble())
}

@ExperimentalUnsignedTypes
fun Heuristic.absoluteHeuristic(state: State): Double {
    val natural = state.naturalOrder
    val range = 0 until state.size
    return range.sumByDouble { x ->
        range.sumByDouble { y ->
            val pos = Coord(x, y)
            val value = state[pos]
            if (value != 0u) {
                heuristic(state, natural, pos, value)
            } else {
                0.0
            }
        }
    }
}

@ExperimentalUnsignedTypes
fun Heuristic.getCoordHeuristicValue(state: State, coords: List<Coord>): List<Pair<Coord, Double>> {
    val natural = state.naturalOrder
    return coords.map { pos ->
        val value = state[pos]
        pos to relativeHeuristic(state, natural, pos, value)
    }
}
