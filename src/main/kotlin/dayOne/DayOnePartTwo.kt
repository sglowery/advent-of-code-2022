package dayOne

import java.io.File

class DayOnePartTwo {
    fun getSumOfTopThreeCalories(file: String): Int {
        val calories = getCalorieListFromFile(file)
        return sumCaloriesByElf(calories).sortedDescending().take(3).sum()
    }

    private fun sumCaloriesByElf(calories: Collection<Int?>): Collection<Int> {
        val allSummedCalories = mutableListOf<Int>()
        var summed = 0
        for (calorie in calories) {
            if (calorie == null) {
                allSummedCalories.add(summed)
                summed = 0
            } else {
                summed += calorie
            }
        }
        return allSummedCalories
    }

    private fun getCalorieListFromFile(file: String): Collection<Int?> {
        return parseFileToStrings(file).map(::toNumberOrNull)
    }

    private fun parseFileToStrings(file: String): Collection<String> {
        return File(file).useLines { it.toList() }
    }

    private fun toNumberOrNull(string: String): Int? = when (string.trim().isEmpty()) {
        true -> null
        false -> Integer.parseInt(string)
    }
}

fun main(args: Array<String>) {
    println(DayOnePartTwo().getSumOfTopThreeCalories(args[0]))
}