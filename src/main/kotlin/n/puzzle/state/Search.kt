package n.puzzle.state

import n.puzzle.heuristics.NaturalOrder
import n.puzzle.heuristics.manhattanDst

@ExperimentalUnsignedTypes
data class Search(val state: State, var coords: List<Coord>) {
    constructor(state: State) : this(state, List<Coord>(0) { state.zero })

    fun addToSolution(coord : Coord) {
        coords += coord
    }

    fun currentState() : State {
        var currentState = state

        for (coord in coords) {
            currentState = (currentState() + coord).first
        }
        return currentState
    }

    fun anticipatedState(coord: Coord) : State {
        return (currentState() + coord).first
    }

    fun solutionCost() : Int {
        return  coords.size
    }

}
