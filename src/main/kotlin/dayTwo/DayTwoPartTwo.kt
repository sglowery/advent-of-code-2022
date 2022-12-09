package dayTwo

import common.parseFileToStringList
import dayTwo.RPSGame.getPlayerWinScoreBonus
import dayTwo.RPSGame.losesAgainst
import dayTwo.RPSGame.winsAgainst


class DayTwoPartTwo {

    fun getScoreForRoundSet(file: String): Int {
        return parseRoundsToPairs(parseFileToStringList(file)).map(::makeChoiceFromGuide).sumOf(::getPlayerScoreForRound)
    }

    private fun getPlayerScoreForRound(round: RPSRound): Int {
        return round.me.score + getPlayerWinScoreBonus(round)
    }

    private fun makeChoiceFromGuide(round: RPSRound): RPSRound {
        return RPSRound(resultToPlayerChoice(round), round.them)
    }

    private fun resultToPlayerChoice(round: RPSRound): Choice = when(round.me) {
        Choice.ROCK -> losesAgainst[round.them]!!
        Choice.SCISSORS -> winsAgainst[round.them]!!
        else -> round.them
    }

}

fun main(args: Array<String>) {
    println(DayTwoPartTwo().getScoreForRoundSet(args.first()))
}