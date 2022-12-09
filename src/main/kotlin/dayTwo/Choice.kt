package dayTwo

enum class Choice(val score: Int) {

    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    companion object {

        private val stringChoiceMap = mapOf(
            "A" to ROCK,
            "X" to ROCK,
            "B" to PAPER,
            "Y" to PAPER,
            "C" to SCISSORS,
            "Z" to SCISSORS
        )

        fun getChoiceFromString(string: String): Choice {
            if (string !in stringChoiceMap.keys) {
                throw RuntimeException("Invalid key for Choice: $string")
            }
            return stringChoiceMap[string]!!
        }
    }
}