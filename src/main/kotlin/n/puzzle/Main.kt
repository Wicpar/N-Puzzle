package n.puzzle

import n.puzzle.heuristics.Manhattan
import n.puzzle.state.Solver
import n.puzzle.state.State
import java.io.File


@ExperimentalUnsignedTypes
@ExperimentalStdlibApi
fun File.checkAndExtract(): Pair<String, State?> {
    return this.readLines().checkAndExtract()
}

@ExperimentalUnsignedTypes
@ExperimentalStdlibApi
fun List<String>.checkAndExtract(): Pair<String, State?> {
    val lines = this.filter { !it.startsWith("#") }.map { it.split("#")[0] }.
            map { it.trim().replace("""[ \t]{2,}""".toRegex()," ") }.toMutableList()
    val size =
        lines.removeFirst().toIntOrNull() ?: return "Invalid File: Error Invalid N-Puzzle size: Not An UInt" to null

    val finalArray = lines.flatMap {
        it.split(" ")
            .map { it.toUIntOrNull() ?: return "Invalid File: Error Invalid Element $it in N-Puzzle" to null }
    }.toUIntArray()

    //System.out.println(finalArray.toSet().size)
    if (finalArray.toSet().size != (size * size))
        return "Invalid File: Some Elements are duplicated or missing" to null

    val nbElem = (size * size).toUInt()
    if (finalArray.any { (it >= (nbElem)) || it < 0U })
        return "Invalid File: Some Elements are out of Range" to null

    val initialState = State(finalArray, size)

    return Pair("Valid", initialState)
}

@ExperimentalUnsignedTypes
@ExperimentalStdlibApi
fun main(args: Array<String>) {

    for (arg in args) {
        val file = File(arg)
        val extractedFile = file.checkAndExtract()
        if (extractedFile.first == "Valid") {
        }
    }
    val arr = uintArrayOf(
        62u,
        21u,
        39u,
        32u,
        8u,
        28u,
        4u,
        60u,
        23u,
        45u,
        7u,
        2u,
        18u,
        24u,
        41u,
        37u,
        29u,
        63u,
        16u,
        1u,
        20u,
        61u,
        17u,
        6u,
        38u,
        55u,
        30u,
        52u,
        12u,
        48u,
        19u,
        13u,
        57u,
        3u,
        5u,
        11u,
        47u,
        0u,
        56u,
        51u,
        53u,
        54u,
        35u,
        50u,
        27u,
        31u,
        10u,
        9u,
        59u,
        25u,
        58u,
        49u,
        14u,
        36u,
        33u,
        44u,
        26u,
        40u,
        46u,
        34u,
        22u,
        42u,
        43u,
        15u
    )
    //val arr =uintArrayOf(15u, 55u, 44u, 35u,  6u,  2u, 26u, 45u, 11u, 17u, 16u,  7u,  4u, 25u,  0u, 27u,  9u, 41u, 40u, 36u, 52u,  5u, 12u, 46u, 38u, 28u, 29u, 33u, 53u, 62u,  8u, 21u, 43u, 59u, 37u, 18u, 24u, 32u, 60u, 50u, 30u, 48u, 63u, 19u, 51u, 23u, 20u, 49u, 42u, 47u, 58u, 22u, 61u, 10u,  1u, 13u, 57u,  3u, 56u, 14u, 34u, 31u, 39u, 54u)
    val solver = Solver(State(arr, 8), Manhattan)

    solver.AStarSolve()

}
