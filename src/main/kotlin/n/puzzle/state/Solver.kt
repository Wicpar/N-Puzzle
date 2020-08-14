package n.puzzle.state

import n.puzzle.heuristics.Heuristic
import n.puzzle.heuristics.absoluteHeuristic
import java.security.Key

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.max

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

    //Data metrics
    private var maxNumberOfStatesInComputedStatesAtOneTime = 0
    private var maxNumberOfStatesAddedToSolutions = 0
    private var FirstSolutionPath : Search? = null
    private var NumberOfIterationBeforeFirstPathFound = 0


    fun AStarDisplaySolution(search: Search) {
        throw NotImplementedError("AStarDisplaySolution method Not implemented.")
    }

    fun AStarSolve() {
        val search = Search(startingState)

        if (aStartSearchManhattan(search)) {
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
            maxNumberOfStatesInComputedStatesAtOneTime = max(computedStates.size, maxNumberOfStatesInComputedStatesAtOneTime)
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

    private fun aStartSearchManhattan(initial: Search): Boolean {
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
                //println("Best Open Cost: ${openPaths.firstKey()}")
                println("Open States: " + computedStates.size)
                println("Best Value: $value/n/n")
                println(search.state)
            }


            var numberOfSuroundingWorseStates = search.state.neighbors().size
            //Regarde les states possibles à atteindre, sans ordre prcis car il est géré lors de l'insertion
            for ((next, step) in search.state.neighborsWithHeuristic(heuristic)) {
                if (computedStates[search.state] ?: Int.MAX_VALUE < value + step)
                    numberOfSuroundingWorseStates--;
                // calcule le nouveau search
                val newSearch = search + next
                //Check if final destination reached
                if (newSearch.state == natural.state) {
                    val maxSteps = maxSteps()
                    val steps = newSearch.steps
                    if (steps <= maxSteps) {
                        //si la solution est plus courte que la précédente
                        if (steps < maxSteps) {
                            //effacer les chemins précédents
                            bestPaths.clear()
                            //accède à la liste des chemins en cours d'évaluation et retire tous les chemins dont
                            //la longeur est plus longue que le nouveau chemin le plus court
                            openPaths.entries.removeIf { it.key.steps >= steps}
                            println("${openPaths.values.sumBy { it.size }} open path costs remaining")
                        }
                        //ajouter la nouvelle solution à la liste des meilleurs chemins
                        if (FirstSolutionPath == null) {
                            FirstSolutionPath = newSearch
                            NumberOfIterationBeforeFirstPathFound = i
                        }
                        maxNumberOfStatesAddedToSolutions += newSearch.steps
                        bestPaths.add(newSearch)
                    }
                } else {
                    // réinserre le search avec la nouvelle valeur heuristique (on ajoute car on minimise)
                    addComputedSearch(newSearch to value + step)
                }
            }
            //Amélioration avec de faibles effets sur le nombre maximun d'état à chaque instant et ralentis la résolution
            if (numberOfSuroundingWorseStates == 0) {
                computedStates.remove(search.state)
            }
        }
        println("$i iterations")
        println("Found ${bestPaths.size} optimal solutions with ${maxSteps()} cost")

        println("optimal Solutions: ${bestPaths.size}")
        println("Best Cost Solutions: ${maxSteps()}")
        println("Open Paths: " + openPaths.values.sumBy { it.size })
        println("Open States: " + computedStates.size)
        println(bestPaths)

        if (FirstSolutionPath != null) {
            println("FirstSolution Found = " + FirstSolutionPath)
            println("Number of iterations before finding first path:" + NumberOfIterationBeforeFirstPathFound)
        }
        println("Number of states added to solutions:" + maxNumberOfStatesAddedToSolutions)
        println("Max number of states at one time in the Evaluated States Map during the resolution:" + maxNumberOfStatesInComputedStatesAtOneTime)

        return bestPaths.isNotEmpty()
    }


}
