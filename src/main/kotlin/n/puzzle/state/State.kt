package n.puzzle.state

import n.puzzle.heuristics.Heuristic
import n.puzzle.heuristics.NaturalOrder
import n.puzzle.heuristics.getCoordHeuristicValue

@ExperimentalUnsignedTypes
class State private constructor(data: Any, val size: Int, private var _zero: Coord) {

    private enum class Size {
        BYTE, SHORT, INT
    }

    private val arraySize: Size
    private val byteArray: UByteArray?
    private val shortArray: UShortArray?
    private val intArray: UIntArray?
    private val dataCopy: Any
        get() = byteArray?.copyOf() ?: shortArray?.copyOf() ?: intArray?.copyOf()!!

    init {
        when (data) {
            is UByteArray -> {
                byteArray = data
                shortArray = null
                intArray = null
                arraySize = Size.BYTE
            }
            is UShortArray -> {

                byteArray = null
                shortArray = data
                intArray = null
                arraySize = Size.SHORT
            }
            else -> {
                byteArray = null
                shortArray = null
                intArray = data as UIntArray
                arraySize = Size.INT
            }
        }
    }

    private operator fun get(idx: Int): UInt {
        return when (arraySize) {
            Size.BYTE -> byteArray!![idx].toUInt()
            Size.SHORT -> shortArray!![idx].toUInt()
            Size.INT -> intArray!![idx]
        }
    }

    private operator fun set(idx: Int, value: UInt) {
        when (arraySize) {
            Size.BYTE -> byteArray!![idx] = value.toUByte()
            Size.SHORT -> shortArray!![idx] = value.toUShort()
            Size.INT -> intArray!![idx] = value
        }
    }

    private fun indexOf(value: UInt): Int {
        return when (arraySize) {
            Size.BYTE -> byteArray!!.indexOf(value.toUByte())
            Size.SHORT -> shortArray!!.indexOf(value.toUShort())
            Size.INT -> intArray!!.indexOf(value)
        }
    }

    companion object {
        private fun minimalData(data: UIntArray, size: Int): Any {
            val max = (size.toUInt() * size.toUInt() - 1u)
            return when {
                max <= UByte.MAX_VALUE.toUInt() -> {
                    data.map { it.toUByte() }.toUByteArray()
                }
                max < UShort.MAX_VALUE.toUInt() -> {
                    data.map { it.toUShort() }.toUShortArray()
                }
                else -> {
                    data
                }
            }
        }
    }

    private var dirty = false

    constructor(data: UIntArray, size: Int) : this(minimalData(data, size), size, data.indexOf(0u).let { Coord(it % size, it / size) })

    constructor(state: State) : this(state.dataCopy, state.size, state._zero)

    val zero: Coord
        get() {
            if (dirty) { recalculateZero() }
            return _zero
        }

    fun recalculateZero() {
        _zero = indexOf(0u).let { Coord(it % size, it / size) }
        dirty = false
    }

    operator fun get(x: Int, y: Int): UInt {
        return this[x + y * size]
    }

    operator fun get(coord: Coord): UInt {
        return this[coord.x, coord.y]
    }

    operator fun set(x: Int, y: Int, value: UInt) {
        this[x + y * size] = value
        dirty = true
    }

    operator fun set(coord: Coord, value: UInt) {
        this[coord.x, coord.y] = value
    }

    operator fun plus(next: Coord): Pair<State, Coord> {
        val new = State(dataCopy, size, next)
        new[_zero] = this[next]
        new[next] = 0u
        new.dirty = false
        return Pair(new, _zero)
    }

    val naturalOrder
        get() = NaturalOrder[size]

    fun neighbors(): List<Coord> {
        val lst = mutableListOf<Coord>()
        val zero = zero
        if (zero.x < size - 1)
            lst += Coord(zero.x + 1, zero.y)
        if (zero.y < size - 1)
            lst += Coord(zero.x, zero.y + 1)
        if (zero.x > 0)
            lst += Coord(zero.x - 1, zero.y)
        if (zero.y > 0)
            lst += Coord(zero.x, zero.y - 1)
        return lst
    }

    fun neighborsWithHeuristic(heuristic: Heuristic): List<Pair<Coord, Double>> {
        return heuristic.getCoordHeuristicValue(this, neighbors())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as State

        return this.arraySize == other.arraySize && when (arraySize) {
            Size.BYTE -> byteArray!!.contentEquals(other.byteArray!!)
            Size.SHORT -> shortArray!!.contentEquals(other.shortArray!!)
            Size.INT -> intArray!!.contentEquals(other.intArray!!)
        }
    }

    override fun hashCode(): Int {
        return when (arraySize) {
            Size.BYTE -> byteArray!!.contentHashCode()
            Size.SHORT -> shortArray!!.contentHashCode()
            Size.INT -> intArray!!.contentHashCode()
        }
    }

    override fun toString(): String {
        val values = when (arraySize) {
            Size.BYTE -> byteArray!!.map { it.toString() }
            Size.SHORT -> shortArray!!.map { it.toString() }
            Size.INT -> intArray!!.map { it.toString() }
        }
        val len = values.map { it.length }.max() ?: 0
        return values.windowed(size, size).joinToString("\n") { it.joinToString(" ") { it.padStart(len, ' ') } }
    }

}
