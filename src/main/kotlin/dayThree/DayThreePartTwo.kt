package dayThree

import common.parseFileToStringList

fun main(args: Array<String>) {
    val rucksacks = parseFileToStringList(args.first())
    val summed = rucksacks.chunked(3)
        .sumOf { rucksackGroup ->
            rucksackGroup.map { it.toSet() }
                .reduce { commonItems, nextRucksack -> commonItems.intersect(nextRucksack) }
                .sumOf { ITEM_PRIORITY_MAP[it] ?: 0 }
        }
    println(summed)
}