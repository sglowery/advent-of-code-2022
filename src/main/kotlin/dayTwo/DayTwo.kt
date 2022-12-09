package dayTwo

import common.parseFileToStringList
import dayTwo.RPSGame.getPlayerWinScoreBonus


class DayTwo {

    fun getScoreForRoundSet(file: String): Int {
        return parseRoundsToPairs(parseFileToStringList(file)).sumOf(::getPlayerScoreForRound)
    }

    private fun getPlayerScoreForRound(round: RPSRound): Int {
        return round.me.score + getPlayerWinScoreBonus(round)
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