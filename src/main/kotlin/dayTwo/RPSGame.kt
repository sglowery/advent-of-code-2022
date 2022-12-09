package dayTwo

object RPSGame {

    const val WIN_BONUS = 6
    const val DRAW_BONUS = 3
    const val LOSE_BONUS = 0

    val winsAgainst = mapOf(
        Choice.ROCK to Choice.PAPER,
        Choice.PAPER to Choice.SCISSORS,
        Choice.SCISSORS to Choice.ROCK
    )

    val losesAgainst = winsAgainst.map { it.value to it.key }.toMap()

    fun getPlayerWinScoreBonus(round: RPSRound): Int = when (round.me) {
        winsAgainst[round.them] -> WIN_BONUS
        round.them -> DRAW_BONUS
        else -> LOSE_BONUS
    }
}