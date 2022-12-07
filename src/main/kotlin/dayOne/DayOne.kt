package dayOne

import common.parseFileToStringList

class DayOne {

    fun findMostCalories(file: String): Int {
        var max = 0
        var currentMax = 0
        val calories: Collection<Int?> = getCalorieListFromFile(file)
        for (calorie in calories) {
            if (calorie != null) {
                currentMax += calorie
                continue
            }
            max = max.coerceAtLeast(currentMax)
            currentMax = 0
        }
        return max
    }

    private fun getCalorieListFromFile(file: String): Collection<Int?> {
        return parseFileToStringList(file).map(::toNumberOrNull)
    }

    private fun toNumberOrNull(string: String): Int? = when (string.trim().isEmpty()) {
        true -> null
        false -> Integer.parseInt(string)
    }

}

fun main(args: Array<String>) {
    println(DayOne().findMostCalories(args[0]))
}