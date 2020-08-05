package n.puzzle

import java.io.File


@ExperimentalStdlibApi
fun File.checkFileFormat(): String {
    var sizeNPuzzle = 0

    val lines = this.readLines().filter { it.startsWith("#") }.map { it.split("#")[0] }.toMutableList()
    val size = lines.removeFirst().toUIntOrNull() ?: return "Invalid File: Error Invalid N-Puzzle size: Not An UInt"
    val array = lines.flatMap {
        it.split(" ").map {
            it.toUIntOrNull() ?: return "Invalid File: Error Invalid Element $it in N-Puzzle"
        }
    }.toUIntArray()



    return "Valid"
}

fun File.extractBaseState(): UIntArray {

    return (UIntArray(0))
}


@ExperimentalStdlibApi
fun main(args: Array<String>) {

    for (arg in args) {
        val file = File(arg)
        if (file.checkFileFormat() == "Valid") {
            file.extractBaseState() // then send to solver
        }

    }

}
