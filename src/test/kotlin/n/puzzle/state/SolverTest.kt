package n.puzzle.state

import n.puzzle.heuristics.*
import org.junit.Assert.*
import org.junit.Test

class SolverTest {

    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @Test
    fun testAStartSearchManhattanSize3() {

        val arr = uintArrayOf(
            7u, 2u, 0u, 5u, 6u, 8u, 3u, 1u, 4u
        )
        val solver = Solver(State(arr, 3), Manhattan)

        solver.AStarSolve()
    }

    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @Test
    fun testAStartSearchManhattanSize4() {

        val arr = uintArrayOf(
            7u, 3u, 15u, 14u, 13u, 10u, 11u, 8u, 9u, 1u, 5u, 0u, 6u, 12u, 2u, 4u
        )
        val solver = Solver(State(arr, 4), Manhattan)

        solver.AStarSolve()
    }

    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @Test
    fun testAStartSearchManhattanSize5() {

        val arr = uintArrayOf(
            3u,
            4u,
            18u,
            6u,
            19u,
            22u,
            10u,
            11u,
            0u,
            7u,
            1u,
            23u,
            21u,
            20u,
            16u,
            15u,
            13u,
            8u,
            9u,
            12u,
            5u,
            14u,
            2u,
            24u,
            17u
        )
        val solver = Solver(State(arr, 5), Manhattan)

        solver.AStarSolve()
    }

    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @Test
    fun testAStartSearchManhattanSize6() {

        val arr = uintArrayOf(
            18u,
            19u,
            32u,
            24u,
            30u,
            29u,
            13u,
            2u,
            0u,
            25u,
            6u,
            35u,
            26u,
            20u,
            17u,
            12u,
            34u,
            31u,
            14u,
            21u,
            33u,
            3u,
            1u,
            8u,
            28u,
            5u,
            22u,
            16u,
            11u,
            4u,
            9u,
            10u,
            27u,
            23u,
            15u,
            7u
        )
        val solver = Solver(State(arr, 6), Manhattan)

        solver.AStarSolve()
    }

    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @Test
    fun testAStartSearchManhattanSize7() {

        val arr = uintArrayOf(
            40u,
            21u,
            8u,
            9u,
            2u,
            6u,
            38u,
            14u,
            3u,
            1u,
            24u,
            26u,
            37u,
            19u,
            41u,
            36u,
            42u,
            10u,
            32u,
            43u,
            30u,
            27u,
            31u,
            12u,
            34u,
            44u,
            5u,
            22u,
            11u,
            15u,
            35u,
            25u,
            18u,
            28u,
            16u,
            23u,
            46u,
            20u,
            4u,
            13u,
            0u,
            48u,
            17u,
            39u,
            45u,
            33u,
            47u,
            7u,
            29u
        )
        val solver = Solver(State(arr, 7), Manhattan)

        solver.AStarSolve()
    }

    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @Test
    fun testAStartSearchManhattanSize8() {

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
        val solver = Solver(State(arr, 8), Manhattan)

        solver.AStarSolve()
    }
//
//    @ExperimentalStdlibApi
//    @ExperimentalUnsignedTypes
//    @Test
//    fun testAStartSearchManhattanSize9() {
//        // too hard for tests but works in main
//        val arr = uintArrayOf(
//            31u, 78u, 58u,  3u, 38u, 34u, 62u, 36u, 40u, 48u,  0u,  1u, 67u, 56u, 16u, 71u, 19u, 35u, 33u,  5u, 27u, 12u,  4u, 42u, 75u,  8u, 29u, 55u, 65u, 68u, 74u, 49u, 45u, 46u, 22u, 64u,  9u, 61u, 21u, 23u, 39u, 43u, 79u, 60u, 66u, 30u, 59u, 72u,  2u, 37u, 53u,  7u, 15u, 17u, 26u, 57u, 54u, 69u, 32u, 18u, 77u, 14u, 76u, 20u, 11u, 25u, 70u, 51u, 52u,  6u, 47u, 28u, 80u, 63u, 73u, 24u, 10u, 50u, 13u, 44u, 41u
//        )
//        val solver = Solver(State(arr, 9), Manhattan)
//
//        solver.AStarSolve()
//    }
//
//    @ExperimentalStdlibApi
//    @ExperimentalUnsignedTypes
//    @Test
//    fun testAStartSearchManhattanSize10() {
//
//        val arr = uintArrayOf(
//            13u,
//            30u,
//            48u,
//            39u,
//            66u,
//            83u,
//            71u,
//            98u,
//            7u,
//            11u,
//            67u,
//            69u,
//            80u,
//            36u,
//            31u,
//            64u,
//            61u,
//            10u,
//            46u,
//            15u,
//            56u,
//            58u,
//            38u,
//            54u,
//            74u,
//            19u,
//            3u,
//            79u,
//            4u,
//            89u,
//            94u,
//            65u,
//            84u,
//            93u,
//            95u,
//            21u,
//            8u,
//            14u,
//            60u,
//            97u,
//            63u,
//            44u,
//            12u,
//            43u,
//            32u,
//            73u,
//            88u,
//            22u,
//            45u,
//            75u,
//            91u,
//            5u,
//            85u,
//            92u,
//            82u,
//            20u,
//            1u,
//            53u,
//            90u,
//            9u,
//            78u,
//            99u,
//            34u,
//            77u,
//            2u,
//            52u,
//            49u,
//            17u,
//            42u,
//            23u,
//            28u,
//            27u,
//            70u,
//            96u,
//            26u,
//            41u,
//            68u,
//            35u,
//            6u,
//            57u,
//            87u,
//            29u,
//            51u,
//            18u,
//            37u,
//            24u,
//            50u,
//            0u,
//            76u,
//            72u,
//            62u,
//            81u,
//            40u,
//            47u,
//            33u,
//            55u,
//            16u,
//            25u,
//            86u,
//            59u
//        )
//        val solver = Solver(State(arr, 10), Manhattan)
//
//        solver.AStarSolve()
//    }

    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @Test
    fun testAStartSearchHammingSize3() {

        val arr = uintArrayOf(
            7u, 2u, 0u, 5u, 6u, 8u, 3u, 1u, 4u
        )
        val solver = Solver(State(arr, 3), Manhattan + Hamming * (1.0/(3*3)))

        solver.AStarSolve()
    }
//
//    @ExperimentalStdlibApi
//    @ExperimentalUnsignedTypes
//    @Test
//    fun testAStartSearchHammingSize4() {
//
//        val arr = uintArrayOf(
//            7u, 3u, 15u, 14u, 13u, 10u, 11u, 8u, 9u, 1u, 5u, 0u, 6u, 12u, 2u, 4u
//        )
//        val solver = Solver(State(arr, 4), Hamming)
//
//        solver.AStarSolve()
//    }
//
//    @ExperimentalStdlibApi
//    @ExperimentalUnsignedTypes
//    @Test
//    fun testAStartSearchHammingSize5() {
//
//        val arr = uintArrayOf(
//            3u,
//            4u,
//            18u,
//            6u,
//            19u,
//            22u,
//            10u,
//            11u,
//            0u,
//            7u,
//            1u,
//            23u,
//            21u,
//            20u,
//            16u,
//            15u,
//            13u,
//            8u,
//            9u,
//            12u,
//            5u,
//            14u,
//            2u,
//            24u,
//            17u
//        )
//        val solver = Solver(State(arr, 5), Hamming)
//
//        solver.AStarSolve()
//    }
//
//    @ExperimentalStdlibApi
//    @ExperimentalUnsignedTypes
//    @Test
//    fun testAStartSearchHammingSize6() {
//
//        val arr = uintArrayOf(
//            18u,
//            19u,
//            32u,
//            24u,
//            30u,
//            29u,
//            13u,
//            2u,
//            0u,
//            25u,
//            6u,
//            35u,
//            26u,
//            20u,
//            17u,
//            12u,
//            34u,
//            31u,
//            14u,
//            21u,
//            33u,
//            3u,
//            1u,
//            8u,
//            28u,
//            5u,
//            22u,
//            16u,
//            11u,
//            4u,
//            9u,
//            10u,
//            27u,
//            23u,
//            15u,
//            7u
//        )
//        val solver = Solver(State(arr, 6), Hamming)
//
//        solver.AStarSolve()
//    }
//
//    @ExperimentalStdlibApi
//    @ExperimentalUnsignedTypes
//    @Test
//    fun testAStartSearchHammingSize7() {
//
//        val arr = uintArrayOf(
//            40u,
//            21u,
//            8u,
//            9u,
//            2u,
//            6u,
//            38u,
//            14u,
//            3u,
//            1u,
//            24u,
//            26u,
//            37u,
//            19u,
//            41u,
//            36u,
//            42u,
//            10u,
//            32u,
//            43u,
//            30u,
//            27u,
//            31u,
//            12u,
//            34u,
//            44u,
//            5u,
//            22u,
//            11u,
//            15u,
//            35u,
//            25u,
//            18u,
//            28u,
//            16u,
//            23u,
//            46u,
//            20u,
//            4u,
//            13u,
//            0u,
//            48u,
//            17u,
//            39u,
//            45u,
//            33u,
//            47u,
//            7u,
//            29u
//        )
//        val solver = Solver(State(arr, 7), Manhattan + Hamming * (0.001))
//
//        solver.AStarSolve()
//    }
//
//    @ExperimentalStdlibApi
//    @ExperimentalUnsignedTypes
//    @Test
//    fun testAStartSearchHammingSize8() {
//
//        val arr = uintArrayOf(
//            62u,
//            21u,
//            39u,
//            32u,
//            8u,
//            28u,
//            4u,
//            60u,
//            23u,
//            45u,
//            7u,
//            2u,
//            18u,
//            24u,
//            41u,
//            37u,
//            29u,
//            63u,
//            16u,
//            1u,
//            20u,
//            61u,
//            17u,
//            6u,
//            38u,
//            55u,
//            30u,
//            52u,
//            12u,
//            48u,
//            19u,
//            13u,
//            57u,
//            3u,
//            5u,
//            11u,
//            47u,
//            0u,
//            56u,
//            51u,
//            53u,
//            54u,
//            35u,
//            50u,
//            27u,
//            31u,
//            10u,
//            9u,
//            59u,
//            25u,
//            58u,
//            49u,
//            14u,
//            36u,
//            33u,
//            44u,
//            26u,
//            40u,
//            46u,
//            34u,
//            22u,
//            42u,
//            43u,
//            15u
//        )
//        val solver = Solver(State(arr, 8), Hamming)
//
//        solver.AStarSolve()
//    }

//    @ExperimentalStdlibApi
//    @ExperimentalUnsignedTypes
//    @Test
//    fun testAStartSearchHammingSize9() {
//
//        val arr = uintArrayOf(
//            6u,
//            76u,
//            16u,
//            33u,
//            45u,
//            26u,
//            0u,
//            80u,
//            61u,
//            34u,
//            70u,
//            38u,
//            71u,
//            43u,
//            27u,
//            67u,
//            39u,
//            7u,
//            23u,
//            36u,
//            5u,
//            62u,
//            48u,
//            17u,
//            59u,
//            65u,
//            21u,
//            56u,
//            40u,
//            53u,
//            3u,
//            64u,
//            52u,
//            78u,
//            69u,
//            4u,
//            75u,
//            79u,
//            15u,
//            29u,
//            10u,
//            35u,
//            60u,
//            20u,
//            63u,
//            57u,
//            24u,
//            46u,
//            11u,
//            73u,
//            74u,
//            49u,
//            8u,
//            72u,
//            9u,
//            50u,
//            32u,
//            41u,
//            12u,
//            31u,
//            54u,
//            77u,
//            58u,
//            1u,
//            13u,
//            22u,
//            51u,
//            2u,
//            47u,
//            55u,
//            30u,
//            28u,
//            44u,
//            25u,
//            66u,
//            37u,
//            68u,
//            42u,
//            18u,
//            14u,
//            19u
//        )
//        val solver = Solver(State(arr, 9), Hamming)
//
//        solver.AStarSolve()
//    }
//
//    @ExperimentalStdlibApi
//    @ExperimentalUnsignedTypes
//    @Test
//    fun testAStartSearchHammingSize10() {
//
//        val arr = uintArrayOf(
//            13u,
//            30u,
//            48u,
//            39u,
//            66u,
//            83u,
//            71u,
//            98u,
//            7u,
//            11u,
//            67u,
//            69u,
//            80u,
//            36u,
//            31u,
//            64u,
//            61u,
//            10u,
//            46u,
//            15u,
//            56u,
//            58u,
//            38u,
//            54u,
//            74u,
//            19u,
//            3u,
//            79u,
//            4u,
//            89u,
//            94u,
//            65u,
//            84u,
//            93u,
//            95u,
//            21u,
//            8u,
//            14u,
//            60u,
//            97u,
//            63u,
//            44u,
//            12u,
//            43u,
//            32u,
//            73u,
//            88u,
//            22u,
//            45u,
//            75u,
//            91u,
//            5u,
//            85u,
//            92u,
//            82u,
//            20u,
//            1u,
//            53u,
//            90u,
//            9u,
//            78u,
//            99u,
//            34u,
//            77u,
//            2u,
//            52u,
//            49u,
//            17u,
//            42u,
//            23u,
//            28u,
//            27u,
//            70u,
//            96u,
//            26u,
//            41u,
//            68u,
//            35u,
//            6u,
//            57u,
//            87u,
//            29u,
//            51u,
//            18u,
//            37u,
//            24u,
//            50u,
//            0u,
//            76u,
//            72u,
//            62u,
//            81u,
//            40u,
//            47u,
//            33u,
//            55u,
//            16u,
//            25u,
//            86u,
//            59u
//        )
//        val solver = Solver(State(arr, 10), Hamming)
//
//        solver.AStarSolve()
//    }


    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @Test
    fun testAStarManhattan1Step() {

        val arr = uintArrayOf(
            1u, 2u, 3u,
            0u, 8u, 4u,
            7u, 6u, 5u
        )
        val solver = Solver(State(arr, 3), Manhattan)

        solver.AStarSolve()
    }

    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @Test
    fun testAStarManhattan2Step() {

        val arr = uintArrayOf(
            0u, 2u, 3u,
            1u, 8u, 4u,
            7u, 6u, 5u
        )
        val solver = Solver(State(arr, 3), Manhattan)

        solver.AStarSolve()
    }

    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @Test
    fun testAStarManhattan3Step() {

        val arr = uintArrayOf(
            2u, 0u, 3u,
            1u, 8u, 4u,
            7u, 6u, 5u
        )
        val solver = Solver(State(arr, 3), Manhattan)

        solver.AStarSolve()
    }

    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @Test
    fun testAStarManhattan4Step() {

        val arr = uintArrayOf(
            2u, 8u, 3u,
            1u, 0u, 4u,
            7u, 6u, 5u
        )
        val solver = Solver(State(arr, 3), Manhattan)

        solver.AStarSolve()
    }

    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @Test
    fun testAStarManhattan5Step() {

        val arr = uintArrayOf(
            2u, 8u, 3u,
            1u, 6u, 4u,
            7u, 0u, 5u
        )
        val solver = Solver(State(arr, 3), Manhattan)

        solver.AStarSolve()
    }


    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @Test
    fun testAStartSearchManhattan() {

        val expectedArray = UIntArray(9) { if (it != 8) it.toUInt() + 1u else 0U }
        //{1,3,5,4,0,2,7,8,6} 6 step solution

        expectedArray[0] = 1u
        expectedArray[1] = 3u
        expectedArray[2] = 5u
        expectedArray[3] = 4u
        expectedArray[4] = 0u
        expectedArray[5] = 2u
        expectedArray[6] = 7u
        expectedArray[7] = 8u
        expectedArray[8] = 6u

        val solver = Solver(State(expectedArray, 3), Manhattan)

        solver.AStarSolve()
    }

}
