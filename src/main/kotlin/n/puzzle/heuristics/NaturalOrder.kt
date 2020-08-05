package n.puzzle.heuristics

import n.puzzle.state.Coord
import n.puzzle.state.State
import java.util.*
import kotlin.collections.HashMap

@ExperimentalUnsignedTypes
class NaturalOrder(size: Int) {

    val indexMap: Map<Int, Coord>
    val state: State


    init {
        val state = State(UIntArray(size * size), size)
        val indexMap = HashMap<Int, Coord>()

        state.recalculateZero()
        this.state = state
        this.indexMap = indexMap
    }

    companion object {
        private val map = Collections.synchronizedMap(HashMap<Int, NaturalOrder>())

        operator fun get(size: Int): NaturalOrder {
           return map.getOrPut(size) { NaturalOrder(size) }
        }
    }

    fun getNaturalIndex(value: Int): Coord? {
        return indexMap[value]
    }

}

@ExperimentalUnsignedTypes
fun State.getNaturalIndex(value: Int): Coord? {
    return NaturalOrder[size].getNaturalIndex(value)
}
