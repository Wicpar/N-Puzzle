package n.puzzle

import n.puzzle.heuristics.NaturalOrder
import org.junit.Assert.*
import org.junit.Test

class MainKtTest {

    @ExperimentalStdlibApi
    @Test
    fun stdEntry(){
        var list = arrayListOf<String>()

        list.add("4")
        list.add("1 2 3")
        list.add("4 5 6")
        list.add("7 8 0")

        System.out.println(list.toSet())

        val result = list.checkAndExtract();

        System.out.println(result.first)
        System.out.println(result.second)
    }
}