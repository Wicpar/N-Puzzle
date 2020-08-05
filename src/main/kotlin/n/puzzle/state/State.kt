package n.puzzle.state

@ExperimentalUnsignedTypes
class State(private val data: UIntArray, val size: Int, private var zero: Coord ) {

    constructor(data: UIntArray, size: Int): this(data, size, data.indexOf(0u).let { Coord(it % size, it / size) })

    fun recalculateZero() {
        zero = data.indexOf(0u).let { Coord(it % size, it / size) }
    }

    operator fun get(x: Int, y: Int): UInt {
        return data[x + y * size]
    }

    operator fun get(coord: Coord): UInt {
        return data[coord.x + coord.y * size]
    }

    operator fun set(x: Int, y: Int, value: UInt) {
        data[x + y * size] = value
    }

    operator fun set(coord: Coord, value: UInt) {
        data[coord.x + coord.y * size] = value
    }

    operator fun plus(next: Coord): Pair<State, Coord> {
        val new = State(data, size, next)
        new[zero] = this[next]
        new[next] = 0u
        return Pair(new, zero)
    }

    fun neighbors(): List<Coord> {
        val lst = mutableListOf<Coord>()
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
        return values.windowed(size, size).joinToString("\n") { it.joinToString(" ") { it.padStart(len, ' ') } }
    }

}
