import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*



/*
 * Complete the 'minimalHeaviestSetA' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun minimalHeaviestSetA(arr: Array<Int>): Array<Int> {
    // Write your code here
    arr.sortDescending()
    val result = mutableListOf<Int>();
    arr.forEachIndexed { index, element ->
        if (result.sum() > arr.copyOfRange(index, arr.lastIndex).sum()) {
            return@forEachIndexed
        }
        //println("Adding to result: $element")
        result.add(element)
    }
    result.sort()
    return result.toTypedArray()
}

fun main(args: Array<String>) {
    val arrCount = readLine()!!.trim().toInt()

    val arr = Array<Int>(arrCount, { 0 })
    for (i in 0 until arrCount) {
        val arrItem = readLine()!!.trim().toInt()
        arr[i] = arrItem
    }

    val result = minimalHeaviestSetA(arr)

    println(result.joinToString("\n"))
}
