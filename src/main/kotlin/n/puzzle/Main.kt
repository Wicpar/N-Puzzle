package n.puzzle

import java.io.File


@ExperimentalStdlibApi
fun File.checkAndExtract(): Pair<String, UIntArray?> {

    val lines = this.readLines().filter { it.startsWith("#") }.map { it.split("#")[0] }.toMutableList()
    val size = lines.removeFirst().toUIntOrNull() ?: return "Invalid File: Error Invalid N-Puzzle size: Not An UInt" to null

    val finalArray = lines.flatMap {
        it.split(" ").map { it.toUIntOrNull() ?: return "Invalid File: Error Invalid Element ${it} in N-Puzzle" to null }
    }.toUIntArray()

    if(finalArray.toSet().size.toUInt() != (size * size))
        return "Invalid File: Some Elements are duplicated" to null

    val nbElem = (size * size)
    if (finalArray.any { (it >= (nbElem))  || it < 0U })
        return "Invalid File: Some Elements are out of Range" to null



    return Pair("Valid", finalArray)
}


@ExperimentalStdlibApi
fun main(args: Array<String>) {

    for (arg in args) {
        val file = File(arg)
        val extractedFile = file.checkAndExtract()
        if (extractedFile.first == "Valid") {

        }
    }

}
