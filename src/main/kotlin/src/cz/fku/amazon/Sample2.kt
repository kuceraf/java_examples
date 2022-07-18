import kotlin.collections.*
import kotlin.io.*


/*
 * Complete the 'countGroups' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING_ARRAY related as parameter.
 */

fun countGroups(related: Array<String>): Int {
    // Write your code here
    var setResult = mutableSetOf<String>()

    val relatedMap = mutableMapOf<Int, MutableList<Int>>()
//    related.forEachIndexed { rIndex, element ->
//        for (cIndex in 0 until element.length) {
//            if (element[cIndex] == '1' && cIndex != rIndex) {
//                // println("one at position: $colIndex:$rowIndex")
//                // check relationship
//                val r = related[cIndex][rIndex]
//                if (r == '1') {
//                    //println("found relation for: $rIndex:$cIndex")
//                    result++
//                }
//            }
//        }
//    }

    for (rIndex in related.indices) {
        relatedMap[rIndex] = mutableListOf<Int>()
        setResult.add("related[$rIndex]")
        val rowStrings = related[rIndex]
        for (cIndex in rowStrings.indices) {
            val rowChar = rowStrings[cIndex]
            if (rowChar == '1' && rIndex != cIndex) {
                setResult.remove("related[$rIndex]")
                val ints = relatedMap[rIndex]
                ints?.add(cIndex)
            }
        }
    }

    println(setResult)
    return setResult.size
}

fun main(args: Array<String>) {
//    val relatedCount = readLine()!!.trim().toInt()
//
//    val related = Array<String>(relatedCount, { "" })
//    for (i in 0 until relatedCount) {
//        val relatedItem = readLine()!!
//        related[i] = relatedItem
//    }

    val input = arrayOf(
        "1100",
        "1110",
        "0110",
        "0001",
    )
    val result = countGroups(input)

    println(result)
}