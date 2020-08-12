package n.puzzle.state

import n.puzzle.heuristics.Heuristic
import n.puzzle.heuristics.absoluteHeuristic

import java.util.*
import kotlin.collections.HashMap

@ExperimentalUnsignedTypes
@ExperimentalStdlibApi
class Solver(val startingState: State, val heuristic: Heuristic) {

    data class SolverCost(val heuristic: Double, val steps: Int): Comparable<SolverCost> {

        override fun compareTo(other: SolverCost): Int {
            return (heuristic + steps).compareTo(other.heuristic + other.steps)
//            return heuristic.compareTo(other.heuristic).let { if (it == 0) steps.compareTo(other.steps) else it }
        }
    }

    private val computedStates = HashMap<State, Int>()
    // ordonné en priorité par prix heuristique puis par cout
    private val openPaths = TreeMap<SolverCost, LinkedList<Search>>()
    private val bestPaths = LinkedList<Search>()

    fun AStarDisplaySolution(search: Search) {
        throw NotImplementedError("AStarDisplaySolution method Not implemented.")
    }

    fun AStarSolve() {
        val search = Search(startingState)

        if (AStartSearchManhattan(search)) {
            println("Success path found !!")
        } else {
            println("No solution Found !!")
        }

    }

    private fun addComputedSearch(data: Pair<Search, Double>) {
        val (search, value) = data
        val steps = computedStates[search.state] ?: Int.MAX_VALUE
        val newSteps = search.steps
        val maxSteps = maxSteps()
        // On élimine si c'est pire ou égal
        if (newSteps < maxSteps && newSteps < steps) {
            computedStates[search.state] = newSteps
            openPaths.getOrPut(SolverCost(value, newSteps)) { LinkedList() }.also {
                it.add(search)
            }
        }
    }

    private fun getNextSearch(): Pair<Double, Search> {
        return openPaths.firstEntry().let { (solverCost, value) ->
            val (heuristicCost, cost) = solverCost
            val ret = value.removeFirst()
            if (value.isEmpty()) {
                openPaths.remove(solverCost)
            }
            heuristicCost to ret
        }
    }

    private fun maxSteps(): Int {
        return bestPaths.firstOrNull()?.steps ?: Int.MAX_VALUE
    }

    fun AStartSearchManhattan(initial: Search): Boolean {
        println("Starting AStar")
        addComputedSearch(initial to heuristic.absoluteHeuristic(initial.state))
        var i = 0

        val natural = initial.state.naturalOrder

        while (openPaths.isNotEmpty()) {
            i++
            val (value, search) = getNextSearch()
            if (i % 1000000 == 0) {
                println("optimal Solutions: ${bestPaths.size}")
                println("Best Cost Solutions: ${maxSteps()}")
                println("Open Paths: " + openPaths.values.sumBy { it.size })
                println("Best Open Cost: ${openPaths.firstKey()}")
                println("Open States: " + computedStates.size)
                println("Best Value: $value")
                println(search.state)
            }
            //Regarde les states possibles à atteindre, sans ordre prcis car il est géré lors de l'insertion
            for ((next, step) in search.state.neighborsWithHeuristic(heuristic)) {
                // calcule le nouveau search
                val newSearch = search + next
                //Check if final destination reached
                if (newSearch.state == natural.state) {
                    val maxSteps = maxSteps()
                    val steps = newSearch.steps
                    if (steps <= maxSteps) {
                        if (steps < maxSteps) {
                            bestPaths.clear()
                            openPaths.entries.removeIf { it.key.steps >= steps}
                            println("${openPaths.values.sumBy { it.size }} open path costs remaining")
                        }
                        bestPaths.add(newSearch)
                    }
                } else {
                    // réinserre le search avec la nouvelle valeur heuristique (on ajoute car on minimise)
                    addComputedSearch(newSearch to value + step)
                }
            }
        }
        println("$i iterations")
        println("Found ${bestPaths.size} optimal solutions with ${maxSteps()} cost")
        println(bestPaths)
        return bestPaths.isNotEmpty()
    }


}
