package n.puzzle.state

@ExperimentalUnsignedTypes
data class Search(val state: State, var coords: CoordSuccession? = null) {

    operator fun plus(step: Coord): Search {
        val (state, coord) = state + step
        return Search(state, coords + coord)
    }

    val steps
        get() = coords?.size ?: 0
}
