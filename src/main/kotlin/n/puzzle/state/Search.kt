package n.puzzle.state

import n.puzzle.heuristics.NaturalOrder
import n.puzzle.heuristics.manhattanDst

@ExperimentalUnsignedTypes
data class Search(val state: State, val coords: List<Coord>) {


    private var openList = listOf<Coord>().toMutableList()
    private var closedList = listOf<Coord>().toMutableList()
    private var solved = false

    constructor(state: State) : this(state, List<Coord>(1) { state.zero })

    fun AStartSearchManhattan() : Search {
        var evaluatedCoord = state.zero

        while (openList.size > 0 && !solved) {
            //Check if final destination reached
            if (state.isNatural()) {
                solved = true
            }
            else {
                openList.remove(evaluatedCoord)
                closedList.add(evaluatedCoord)
                for (neighbor in state .neighbors() ) {
                    val neighboringState = state + neighbor

                    if (openList.none{ it == neighbor } && closedList.none{ it == neighbor }) {
                        openList.add(evaluatedCoord)
                        coords.toMutableList().add(neighbor)
                    }
                    else if ( manhattanDst(neighbor, state.NaturalState().zero) > manhattanDst(evaluatedCoord, state.NaturalState().zero)) {
                        coords.toMutableList().add(evaluatedCoord)
                        if (closedList.any{ it == neighbor }) {
                            closedList.remove(neighbor)
                            openList.add(neighbor)
                        }
                    }
                }
            }
            print(this.coords)
        }
        return this
    }

}
