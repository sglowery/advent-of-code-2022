package dayTwo

import common.parseFileToStringList

private const val WIN_BONUS = 6
private const val DRAW_BONUS = 3

class DayTwo {

    data class RPSRound(val me: Choice, val them: Choice)

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

    fun getScoreForRoundSet(file: String): Int {
        return parseRoundsToPairs(parseFileToStringList(file)).sumOf(::getPlayerScoreForRound)
    }

    private val winsAgainst = mapOf(
        Choice.ROCK to Choice.PAPER,
        Choice.PAPER to Choice.SCISSORS,
        Choice.SCISSORS to Choice.ROCK
    )

    private fun getPlayerScoreForRound(round: RPSRound): Int {
        return round.me.score + getPlayerWinScoreBonus(round)
    }

    private fun getPlayerWinScoreBonus(round: RPSRound): Int = when (round.me) {
        winsAgainst[round.them] -> WIN_BONUS
        round.them -> DRAW_BONUS
        else -> 0
    }

    private fun parseRoundsToPairs(rounds: Collection<String>): Collection<RPSRound> {
        return rounds.map { round ->
            round.split(" ")
                .let {
                    RPSRound(Choice.getChoiceFromString(it.last()), Choice.getChoiceFromString(it.first()))
                }
        }
    }

}

fun main(args: Array<String>) {
    println(DayTwo().getScoreForRoundSet(args.first()))
}