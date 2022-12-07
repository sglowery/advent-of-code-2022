package common

import java.io.File

fun parseFileToStringList(file: String): Collection<String> = File(file).useLines { it.toList() }