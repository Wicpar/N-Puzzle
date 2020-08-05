package n.puzzle.state

@ExperimentalUnsignedTypes
class State(private val data: UIntArray, val size: UInt, val zero: Coord) {

    constructor(data: UIntArray, size: UInt): this(data, size, data.indexOf(0u).let {
        Coord((it % size.toInt()).toUInt(), (it / size.toInt()).toUInt())
    })

    operator fun get(x: UInt, y: UInt): UInt {
        return data[(x + y * size).toInt()]
    }

    operator fun get(coord: Coord): UInt {
        return data[(coord.x + coord.y * size).toInt()]
    }

    operator fun set(x: UInt, y: UInt, value: UInt) {
        data[(x + y * size).toInt()] = value
    }

    operator fun set(coord: Coord, value: UInt) {
        data[(coord.x + coord.y * size).toInt()] = value
    }

    operator fun plus(next: Coord): Pair<State, Coord> {
        val new = State(data, size, next)
        new[zero] = this[next]
        new[next] = 0u
        return Pair(new, zero)
    }

    fun neighbors(): List<Coord> {
        val lst = mutableListOf<Coord>()
        if (zero.x < size - 1u)
            lst += Coord(zero.x + 1u, zero.y)
        if (zero.y < size - 1u)
            lst += Coord(zero.x, zero.y + 1u)
        if (zero.x > 0u)
            lst += Coord(zero.x - 1u, zero.y)
        if (zero.y > 0u)
            lst += Coord(zero.x, zero.y - 1u)
        return lst
    }

    inline fun <R : Comparable<R>> bestCoord(fn: State.(pos: Coord, value: UInt) -> R): Coord {
        return neighbors().minBy { fn(it, this[it]) }!! // 0 grids are impossible
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as State

        if (data != other.data) return false

        return true
    }

    override fun hashCode(): Int {
        return data.hashCode()
    }

    override fun toString(): String {
        val values = data.map { it.toString() }
        val len = values.map { it.length }.max() ?: 0
        return values.windowed(size.toInt(), size.toInt()).joinToString("\n") { it.joinToString(" ") { it.padStart(len, ' ') } }
    }

}
