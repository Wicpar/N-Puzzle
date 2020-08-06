package n.puzzle.state

import n.puzzle.heuristics.NaturalOrder

@ExperimentalUnsignedTypes
class State(private val data: UIntArray, val size: Int, private var _zero: Coord) {

    private var dirty = false

    constructor(data: UIntArray, size: Int) : this(data, size, data.indexOf(0u).let { Coord(it % size, it / size) })

    val zero: Coord
        get() {
            if (dirty) { recalculateZero() }
            return _zero
        }

    fun recalculateZero() {
        _zero = data.indexOf(0u).let { Coord(it % size, it / size) }
        dirty = false
    }

    operator fun get(x: Int, y: Int): UInt {
        return data[x + y * size]
    }

    operator fun get(coord: Coord): UInt {
        return this[coord.x, coord.y]
    }

    operator fun set(x: Int, y: Int, value: UInt) {
        data[x + y * size] = value
        dirty = true
    }

    operator fun set(coord: Coord, value: UInt) {
        this[coord.x, coord.y] = value
    }

    operator fun plus(next: Coord): Pair<State, Coord> {
        val new = State(data, size, next)
        new[_zero] = this[next]
        new[next] = 0u
        new.dirty = false
        return Pair(new, _zero)
    }

    fun isNatural(): Boolean {
        return NaturalOrder[size].state == this
    }

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

    inline fun <R : Comparable<R>> bestCoord(crossinline fn: State.(pos: Coord, target: Coord, value: UInt) -> R): List<Coord> {
        val natural = NaturalOrder[size]
        return neighbors().sortedBy {
            val value = this[it]
            fn(it, natural.getNaturalIndex(value)!!, value)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as State

        return data.contentEquals(other.data)
    }

    override fun hashCode(): Int {
        return data.contentHashCode()
    }

    override fun toString(): String {
        val values = data.map { it.toString() }
        val len = values.map { it.length }.max() ?: 0
        return values.windowed(size, size).joinToString("\n") { it.joinToString(" ") { it.padStart(len, ' ') } }
    }

}
