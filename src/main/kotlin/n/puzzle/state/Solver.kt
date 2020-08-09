package n.puzzle.state

import n.puzzle.state.Search

import n.puzzle.heuristics.manhattan
import n.puzzle.heuristics.manhattanDst

class Solver (val startingState : State) {

    fun AStarDisplaySolution(search: Search) {
        throw NotImplementedError("AStarDisplaySolution method Not implemented.")
    }

    fun AStarSolve() {
        var search = Search(startingState)

        search.AStartSearchManhattan()
        AStarDisplaySolution( search )

    }

}