package dayTwo

fun parseRoundsToPairs(rounds: Collection<String>): Collection<RPSRound> {
    return rounds.map { round ->
        round.split(" ")
            .let {
                RPSRound(Choice.getChoiceFromString(it.last()), Choice.getChoiceFromString(it.first()))
            }
    }
}