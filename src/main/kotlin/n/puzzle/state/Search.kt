package n.puzzle.state

@ExperimentalUnsignedTypes
data class Search(val state: State, val steps: ArrayList<Step>)
