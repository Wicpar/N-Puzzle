package n.puzzle.state

class CoordSuccession(val coord: Coord, val next: CoordSuccession? = null, val size: Int = next?.size?.plus(1) ?: 1) {

    private val hashcode by lazy(LazyThreadSafetyMode.NONE) {
        var result = coord.hashCode()
        result = 31 * result + (next?.hashCode() ?: 0)
        result = 31 * result + size
        result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CoordSuccession

        if (coord != other.coord) return false
        if (next != other.next) return false
        if (size != other.size) return false

        return true
    }

    override fun hashCode(): Int = hashcode

    override fun toString(): String {
        return "$coord${if (next != null) ", $next" else ""}"
    }
}

operator fun CoordSuccession?.plus(coord: Coord): CoordSuccession {
    return CoordSuccession(coord, this)
}
