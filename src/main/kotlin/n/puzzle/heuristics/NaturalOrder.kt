package n.puzzle.heuristics

import n.puzzle.state.Coord
import n.puzzle.state.State
import java.util.*
import kotlin.collections.HashMap

@ExperimentalUnsignedTypes
class NaturalOrder(size: Int) {

    private val indexMap: Map<UInt, Coord>
    val state: State

    init {
        val state = State(UIntArray(size * size), size)
        val indexMap = HashMap<UInt, Coord>()

        var offsetX = -1
        var offsetY = 0
        var idx = 1u
        (size downTo 0).forEach {len ->
            val move = if ((size - len) % 2 == 0) 1 else -1
            if (len != size) {
                repeat(len) {
                    offsetY -= move
                    state[offsetX, offsetY] = idx
                    indexMap[idx] = Coord(offsetX, offsetY)
                    idx += 1u
                }
            }
            if (len != 1) {
                repeat(len) {
                    offsetX += move
                    state[offsetX, offsetY] = idx
                    indexMap[idx] = Coord(offsetX, offsetY)
                    idx += 1u
                }
            }
        }
        state.recalculateZero()
        this.state = state
        this.indexMap = indexMap
    }

    companion object {
        private val map = Collections.synchronizedMap(HashMap<Int, NaturalOrder>())

        @Synchronized
        operator fun get(size: Int): NaturalOrder {
           return map.getOrPut(size) { NaturalOrder(size) }
        }
    }

    fun getNaturalIndex(value: UInt): Coord? {
        return indexMap[value]
    }

}
