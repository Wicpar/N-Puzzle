package n.puzzle

import n.puzzle.state.Coord
import n.puzzle.state.State
import java.io.File


@ExperimentalUnsignedTypes
@ExperimentalStdlibApi
fun File.checkAndExtract(): Pair<String, State?> {
    val lines = this.readLines().filter { it.startsWith("#") }.map { it.split("#")[0] }.toMutableList()
    val size =
        lines.removeFirst().toUIntOrNull() ?: return "Invalid File: Error Invalid N-Puzzle size: Not An UInt" to null

    val finalArray = lines.flatMap {
        it.split(" ")
            .map { it.toUIntOrNull() ?: return "Invalid File: Error Invalid Element ${it} in N-Puzzle" to null }
    }.toUIntArray()

    if (finalArray.toSet().size.toUInt() != (size * size))
        return "Invalid File: Some Elements are duplicated" to null

    val nbElem = (size * size)
    if (finalArray.any { (it >= (nbElem)) || it < 0U })
        return "Invalid File: Some Elements are out of Range" to null

    val initialState =
        State(finalArray, size, Coord(finalArray.indexOf(0U).toUInt() % size, finalArray.indexOf(0U).toUInt() / size))

    return Pair("Valid", initialState)
}

@ExperimentalUnsignedTypes
@ExperimentalStdlibApi
fun List<String>.checkAndExtract(): Pair<String, State?> {
    val lines = this.filter { it.startsWith("#") }.map { it.split("#")[0] }.toMutableList()
    val size =
        lines.removeFirst().toUIntOrNull() ?: return "Invalid File: Error Invalid N-Puzzle size: Not An UInt" to null

    val finalArray = lines.flatMap {
        it.split(" ")
            .map { it.toUIntOrNull() ?: return "Invalid File: Error Invalid Element ${it} in N-Puzzle" to null }
    }.toUIntArray()

    if (finalArray.toSet().size.toUInt() != (size * size))
        return "Invalid File: Some Elements are duplicated" to null

    val nbElem = (size * size)
    if (finalArray.any { (it >= (nbElem)) || it < 0U })
        return "Invalid File: Some Elements are out of Range" to null

    val initialState =
        State(finalArray, size, Coord(finalArray.indexOf(0U).toUInt() % size, finalArray.indexOf(0U).toUInt() / size))

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

}
