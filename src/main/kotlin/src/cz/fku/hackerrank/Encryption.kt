package cz.fku.hackerrank

import java.util.DoubleSummaryStatistics
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

class Encryption {
}

fun encryption(s: String): String {
    // Write your code here
    val sNoSpace = s.replace(" ", "")
    val pair = computeRowAndColumn(sNoSpace.length)
    //println(pair)
    val strings = sNoSpace.chunked(pair.second)
    val sb = StringBuilder()
    for (i in 0..pair.second) {
        strings.forEach {
            if (i < it.length) {
                sb.append(it[i])
            }
        }
        sb.append(" ")
    }
    return sb.toString()
        // .also { println(it) }
}

fun computeRowAndColumn(length: Int): Pair<Int, Int> {
    val lengthSqrt = sqrt(length.toDouble())
    var floor = floor(lengthSqrt)
    val ceil = ceil(lengthSqrt)
    while (floor * ceil < length) {
        floor++
    }
    return Pair(floor.toInt(), ceil.toInt())
}

fun main() {
    encryption("haveaniceday")
}