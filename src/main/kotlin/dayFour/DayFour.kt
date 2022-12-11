package dayFour

import common.parseFileToStringList

private fun toRange(string: String): IntRange = string.split("-")
    .map(Integer::parseInt)
    .let { it.first()..it.last() }

private fun toRangePairs(strings: List<String>): Pair<IntRange, IntRange> =
    strings.map(::toRange).let { it.first() to it.last() }

private fun IntRange.completelyContains(other: IntRange) =
    this.first <= other.first && this.last >= other.last

fun main(args: Array<String>) {
    val assignmentPairs = parseFileToStringList(args.first())
        .map { it.split(",") }
        .map(::toRangePairs)
        .count { it.first.completelyContains(it.second) || it.second.completelyContains(it.first) }
    println(assignmentPairs)
}