package n.puzzle


import n.puzzle.state.State
import org.junit.Assert
import org.junit.Test

class MainKtTest {

    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3_BaseEntry() {
        System.out.println("-------\nStart Standard 3 by 3")
        val list = arrayListOf<String>()

        list.add("3")
        list.add("1 2 3")
        list.add("4 5 6")
        list.add("7 8 0")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        System.out.println(result.first)
        System.out.println(result.second)

        val expectedArray = UIntArray(9) { if (it != 8) it.toUInt() + 1u else 0U }

        val expectedState = State(expectedArray, 3)
        Assert.assertEquals("Valid", result.first)
        Assert.assertEquals(expectedState, result.second)

        System.out.println("ExpectedState:\n" + expectedState)
        System.out.println("ExpectedSize:\n" + expectedState.size)

        System.out.println("ActualState:\n" + result.second)
        System.out.println("ActualSize:\n" + result.second?.size)

        if (expectedState.toString().equals(result.second.toString()))
            System.out.println("Equals")
        else
            System.out.println("NOT Equals")

    }

    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3WithStartingComments_BaseEntry() {
        System.out.println("-------\nStart Standard 3 by 3")
        val list = arrayListOf<String>()

        list.add("#Basic comments")
        list.add("3")
        list.add("1 2 3")
        list.add("4 5 6")
        list.add("7 8 0")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        System.out.println(result.first)
        System.out.println(result.second)

        val expectedArray = UIntArray(9) { if (it != 8) it.toUInt() + 1u else 0U }

        val expectedState = State(expectedArray, 3)
        Assert.assertEquals("Valid", result.first)
        Assert.assertEquals(expectedState, result.second)

        System.out.println("ExpectedState:\n" + expectedState)
        System.out.println("ExpectedSize:\n" + expectedState.size)

        System.out.println("ActualState:\n" + result.second)
        System.out.println("ActualSize:\n" + result.second?.size)

        if (expectedState.toString().equals(result.second.toString()))
            System.out.println("Equals")
        else
            System.out.println("NOT Equals")

    }

    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3WithInbetweenLineComments_BaseEntry() {
        System.out.println("-------\nStart Standard 3 by 3")
        val list = arrayListOf<String>()

        list.add("3")
        list.add("1 2 3")
        list.add("#Basic comments")
        list.add("4 5 6")
        list.add("7 8 0")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        System.out.println(result.first)
        System.out.println(result.second)

        val expectedArray = UIntArray(9) { if (it != 8) it.toUInt() + 1u else 0U }

        val expectedState = State(expectedArray, 3)
        Assert.assertEquals("Valid", result.first)
        //Assert.assertEquals(expectedState, result.second)

        System.out.println("ExpectedState:\n" + expectedState)
        System.out.println("ExpectedSize:\n" + expectedState.size)

        System.out.println("ActualState:\n" + result.second)
        System.out.println("ActualSize:\n" + result.second?.size)

        if (expectedState.toString().equals(result.second.toString()))
            System.out.println("Equals")
        else
            System.out.println("NOT Equals")

    }

    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3WithEndComments_BaseEntry() {
        System.out.println("-------\nStart Standard 3 by 3")
        val list = arrayListOf<String>()

        list.add("3")
        list.add("1 2 3")
        list.add("4 5 6")
        list.add("7 8 0")
        list.add("#Basic comments")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        System.out.println(result.first)
        System.out.println(result.second)

        val expectedArray = UIntArray(9) { if (it != 8) it.toUInt() + 1u else 0U }

        val expectedState = State(expectedArray, 3)
        Assert.assertEquals("Valid", result.first)
        Assert.assertEquals(expectedState, result.second)

        System.out.println("ExpectedState:\n" + expectedState)
        System.out.println("ExpectedSize:\n" + expectedState.size)

        System.out.println("ActualState:\n" + result.second)
        System.out.println("ActualSize:\n" + result.second?.size)

        if (expectedState.toString().equals(result.second.toString()))
            System.out.println("Equals")
        else
            System.out.println("NOT Equals")

    }

    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3WithEndOfLineComments_BaseEntry() {
        System.out.println("-------\nStart Standard 3 by 3")
        val list = arrayListOf<String>()

        list.add("3")
        list.add("1 2 3")
        list.add("4 5 6 #Basic comments")
        list.add("7 8 0")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        System.out.println(result.first)
        System.out.println(result.second)

        val expectedArray = UIntArray(9) { if (it != 8) it.toUInt() + 1u else 0U }

        val expectedState = State(expectedArray, 3)
        Assert.assertEquals("Valid", result.first)
        Assert.assertEquals(expectedState, result.second)

        System.out.println("ExpectedState:\n" + expectedState)
        System.out.println("ExpectedSize:\n" + expectedState.size)

        System.out.println("ActualState:\n" + result.second)
        System.out.println("ActualSize:\n" + result.second?.size)

        if (expectedState.toString().equals(result.second.toString()))
            System.out.println("Equals")
        else
            System.out.println("NOT Equals")
    }

    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3WithDoubleEndOfLineComments_HardEntry() {
        System.out.println("-------\nStart Standard 3 by 3")
        val list = arrayListOf<String>()

        list.add("3")
        list.add("1 2 3")
        list.add("4 5 6 #Basic comments #Basic comments")
        list.add("7 8 0")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        System.out.println(result.first)
        System.out.println(result.second)

        val expectedArray = UIntArray(9) { if (it != 8) it.toUInt() + 1u else 0U }

        val expectedState = State(expectedArray, 3)
        Assert.assertEquals("Valid", result.first)
        Assert.assertEquals(expectedState, result.second)

        System.out.println("ExpectedState:\n" + expectedState)
        System.out.println("ExpectedSize:\n" + expectedState.size)

        System.out.println("ActualState:\n" + result.second)
        System.out.println("ActualSize:\n" + result.second?.size)

        if (expectedState.toString().equals(result.second.toString()))
            System.out.println("Equals")
        else
            System.out.println("NOT Equals")
    }

    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3WithSpacesAtEndOfLine_HardEntry() {
        System.out.println("-------\nStart Standard 3 by 3 with spaces")
        val list = arrayListOf<String>()

        list.add("3")
        list.add("1 2 3")
        list.add("4 5 6 ")
        list.add("7 8 0")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        System.out.println(result.first)
        System.out.println(result.second)

        val expectedArray = UIntArray(9) { if (it != 8) it.toUInt() + 1u else 0U }

        val expectedState = State(expectedArray, 3)
        Assert.assertEquals("Valid", result.first)
        Assert.assertEquals(expectedState, result.second)

        System.out.println("ExpectedState:\n" + expectedState)
        System.out.println("ExpectedSize:\n" + expectedState.size)

        System.out.println("ActualState:\n" + result.second)
        System.out.println("ActualSize:\n" + result.second?.size)

        if (expectedState.toString().equals(result.second.toString()))
            System.out.println("Equals")
        else
            System.out.println("NOT Equals")

    }


    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3WithSpacesAtBeginOfLine_HardEntry() {
        System.out.println("-------\nStart Standard 3 by 3 with spaces at begining of line")
        val list = arrayListOf<String>()

        list.add("3")
        list.add("1 2 3")
        list.add(" 4 5 6")
        list.add("7 8 0")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        System.out.println(result.first)
        System.out.println(result.second)

        val expectedArray = UIntArray(9) { if (it != 8) it.toUInt() + 1u else 0U }

        val expectedState = State(expectedArray, 3)
        Assert.assertEquals("Valid", result.first)
        Assert.assertEquals(expectedState, result.second)

        System.out.println("ExpectedState:\n" + expectedState)
        System.out.println("ExpectedSize:\n" + expectedState.size)

        System.out.println("ActualState:\n" + result.second)
        System.out.println("ActualSize:\n" + result.second?.size)

        if (expectedState.toString().equals(result.second.toString()))
            System.out.println("Equals")
        else
            System.out.println("NOT Equals")

    }

    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3WithExtraSpacesBetweenNumers_HardEntry() {
        System.out.println("-------\nStart Standard 3 by 3 with extra spaces between entries")
        val list = arrayListOf<String>()

        list.add("3")
        list.add("1 2   3")
        list.add("4   5 6")
        list.add("7 8  0")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        System.out.println(result.first)
        System.out.println(result.second)

        val expectedArray = UIntArray(9) { if (it != 8) it.toUInt() + 1u else 0U }

        val expectedState = State(expectedArray, 3)
        Assert.assertEquals("Valid", result.first)
        Assert.assertEquals(expectedState, result.second)

        System.out.println("ExpectedState:\n" + expectedState)
        System.out.println("ExpectedSize:\n" + expectedState.size)

        System.out.println("ActualState:\n" + result.second)
        System.out.println("ActualSize:\n" + result.second?.size)

        if (expectedState.toString().equals(result.second.toString()))
            System.out.println("Equals")
        else
            System.out.println("NOT Equals")

    }

    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3WithIllegalSymbolsLineOnLine_Error() {
        System.out.println("-------\nStart Standard 3 by 3 with Illegal Char")
        val list = arrayListOf<String>()

        list.add("3")
        list.add("1 2 3")
        list.add("4a 5 6")
        list.add("7 8 0")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        Assert.assertEquals("Invalid File: Error Invalid Element 4a in N-Puzzle", result.first)
        Assert.assertEquals(null, result.second)
    }

    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3WithNumberSwappedByIllegalSymbolsLine_Error() {
        System.out.println("-------\nStart Standard 3 by 3 with Illegal Char")
        val list = arrayListOf<String>()

        list.add("3")
        list.add("1 2 3")
        list.add("a 5 6")
        list.add("7 8 0")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        Assert.assertEquals("Invalid File: Error Invalid Element a in N-Puzzle", result.first)
        Assert.assertEquals(null, result.second)
    }

    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3WithNumberWithIllegalSymboInsertedInside_Error() {
        System.out.println("-------\nStart Standard 3 by 3 with Illegal Char")
        val list = arrayListOf<String>()

        list.add("3")
        list.add("1 2 3")
        list.add("4a74 5 6")
        list.add("7 8 0")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        Assert.assertEquals("Invalid File: Error Invalid Element 4a74 in N-Puzzle", result.first)
        Assert.assertEquals(null, result.second)
    }


    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3WithEmptyPuzzleLineMapSize_Error() {
        System.out.println("-------\nStart Standard 3 by 3 with Empty Size Line")
        val list = arrayListOf<String>()

        list.add("")
        list.add("1 2 3")
        list.add("4 5 6")
        list.add("7 8 0")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        Assert.assertEquals("Invalid File: Error Invalid N-Puzzle size: Not An UInt", result.first)
        Assert.assertEquals(null, result.second)
    }

    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3WithoutMapSize_Error() {
        System.out.println("-------\nStart Standard 3 by 3 with Empty Size Line")
        val list = arrayListOf<String>()

        list.add("2 1 3")
        list.add("4 5 6")
        list.add("7 8 0")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        Assert.assertEquals("Invalid File: Error Invalid N-Puzzle size: Not An UInt", result.first)
        Assert.assertEquals(null, result.second)

    }

    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3WithoutMapSizeAnd2x2linesAfter_Error() {
        System.out.println("-------\nStart Standard 3 by 3 with Empty Size Line")
        val list = arrayListOf<String>()

        list.add("2 1 3")
        list.add("4 5")
        list.add("6 0")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        Assert.assertEquals("Invalid File: Error Invalid N-Puzzle size: Not An UInt", result.first)
        Assert.assertEquals(null, result.second)
    }

    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3WithWrongMapSize_Error() {
        System.out.println("-------\nStart Standard 3 by 3 with Empty Size Line")
        val list = arrayListOf<String>()

        list.add("4")
        list.add("2 1 3")
        list.add("4 5 6")
        list.add("7 8 0")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        System.out.println(result.first)
        System.out.println(result.second)

        Assert.assertEquals("Invalid File: Some Elements are duplicated or missing", result.first)
        Assert.assertEquals(null, result.second)
    }

    @ExperimentalUnsignedTypes
    @ExperimentalStdlibApi
    @Test
    fun stdEntryWithValid3x3WithOutStartingState_Error() {
        System.out.println("-------\nStart Standard 3 by 3 without starting state")
        val list = arrayListOf<String>()

        list.add("3")

        System.out.println(list.toSet())

        val result = list.checkAndExtract()

        Assert.assertEquals("Invalid File: Some Elements are duplicated or missing", result.first)
        Assert.assertEquals(null, result.second)
    }


}