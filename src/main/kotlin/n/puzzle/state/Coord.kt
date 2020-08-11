package n.puzzle.state

@ExperimentalUnsignedTypes
data class Coord(val x: Int, val y: Int) {
    override fun toString(): String {
        return "($x, $y)"
    }
}
