package dayThree

import common.parseFileToStringList

val ITEM_PRIORITY_MAP = (('a'..'z') + ('A'..'Z')).zip((1..52)).toMap()

fun main(args: Array<String>) {
    val rucksacks = parseFileToStringList(args.first())
    val summedRepeatedPriorities = rucksacks.sumOf { rucksack ->
        rucksack.chunked(rucksack.length / 2)
            .map { it.toSet() }
            .let { it.first().intersect(it.last()) }
            .sumOf { ITEM_PRIORITY_MAP[it] ?: 0 }
    }
    println(summedRepeatedPriorities)
}