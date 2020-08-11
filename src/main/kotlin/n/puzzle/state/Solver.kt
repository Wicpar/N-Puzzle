package n.puzzle.state

import n.puzzle.state.Search

import n.puzzle.heuristics.manhattan
import n.puzzle.heuristics.manhattanDst

class Solver(val startingState: State) {


    private var openList = listOf<State>().toMutableList()
    private var closedList = listOf<State>().toMutableList()
    private var solved = false


    fun AStarDisplaySolution(search: Search) {
        throw NotImplementedError("AStarDisplaySolution method Not implemented.")
    }

    fun AStarSolve() {
        var search = Search(startingState)

        if (AStartSearchManhattan(search)) {
            println("Success path found !!")
        } else {
            println("No solution Found !!")
        }

    }

    fun AStartSearchManhattan(search : Search): Boolean {
        println("Starting AStar")
        openList.add(search.state)
        var i = 0

        while (openList.size > 0 && !solved) {
            i++
            println("Iteration:" + i)
            println("Coords = " + search.coords)
            println("Grid = \n" + search.state)
            println("Open list:")
            for (state in openList) {
                println(state)
            }
            println("Closed list:")
            for (state in closedList) {
                println(state)
            }

            if (i > 5)
                return false
            //Check if final destination reached
            if (search.state.isNatural()) {
                println("Is Solved")
                solved = true
            } else {
                openList.remove(search.state)
                closedList.add(search.state)
                //Regarde les states possibles à atteindre depuis la position actuelle trié par ordre de pertinence
                for (neighbor in search.currentState().neighbors()) {
                    //prend un state qui n'a pas encore été exploré
                    if (openList.none { it ==  search.anticipatedState(neighbor)  } &&
                        closedList.none { it ==  search.anticipatedState(neighbor)  }) {
                        //ajoute a la liste de recherche prioritaire
                        openList.add(search.anticipatedState(neighbor))
                        //ajoute au chemin en cours de création afin que search current state donne bien le state actuelle
                        search.addToSolution(neighbor)
                        break
                    }/* else if (manhattanDst(neighbor, search.state.NaturalState().zero) >
                            manhattanDst( search.state.zero, search.state.NaturalState().zero
                        )
                    ) {
                        search.addToSolution(neighbor)
                        search.state + neighbor
                        if (closedList.any { it == (search.state + neighbor).first }) {
                            closedList.remove((search.state + neighbor).first)
                            openList.add((search.state + neighbor).first)
                        }
                        break
                    }*/
                }
            }
            println("Search Coords = " + search.coords)
        }
        println("End of A*")
        println("Coords = " + search.coords)
        println("Grid = \n" + search.state)
        println("Open list:")
        for (state in openList) {
            println(state)
        }
        println("Closed list:")
        for (state in closedList) {
            println(state)
        }

        return solved
    }


}