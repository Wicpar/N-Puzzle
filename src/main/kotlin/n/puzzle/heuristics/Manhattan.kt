package n.puzzle.heuristics

import n.puzzle.state.Coord
import n.puzzle.state.State
import kotlin.math.abs

@ExperimentalUnsignedTypes
fun manhattanDst(a: Coord, b: Coord) = abs(a.x - b.x) + abs(a.y - b.y)

@ExperimentalUnsignedTypes
fun State.manhattan(pos: Coord, target: Coord, value: UInt): Double {
    return abs(manhattanDst(zero, target) - manhattanDst(pos, target)).toDouble()
}
