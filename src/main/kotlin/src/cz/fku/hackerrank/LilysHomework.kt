package cz.fku.hackerrank

import cz.fku.udemy.dataStructureAlgo.log

class LilysHomework {
}

fun lilysHomework(org: Array<Int>): Int {
    // dsc 15, 12, 7, 3
    // 1
    // org 3, 7, 15, 12
    // 2 -- 15 swap 3 - index 0 swap 2 at org
    // org 3, 7, 15, 12

    // compare org with desc and swap org if differ
    return Math.min(
        swapCount(org.clone(), org.sortedArray()).also { println("asc result: $it") },
        swapCount(org.clone(), org.sortedArrayDescending()).also { println("dsc result: $it") }
    )
}

private fun swapCount(org: Array<Int>, dsc: Array<Int>): Int {
    var swaps = 0
    val mapOrg = mutableMapOf<Int, Int>()
    org.forEachIndexed { i, e ->
        mapOrg[e] = i
    }
    for (i in org.indices) {
        if (dsc[i] != org[i]) {
            // val swapIndex = org.indexOf(dsc[i])
            org[getSwapIndex(org[i],dsc[i],mapOrg)] = org[i]
            org[i] = dsc[i]
            // log("swap", org)
            swaps++
        }
    }
    return swaps
}

fun getSwapIndex(orgE: Int, dscE: Int, lookUpMap: MutableMap<Int, Int>): Int {
    val swapIndex = lookUpMap[dscE]
    lookUpMap[dscE] = lookUpMap[orgE]!!
    lookUpMap[orgE] = swapIndex!!
    return swapIndex
}

fun main() {
    val inputArray = arrayOf(3, 7, 15, 12)
//val inputArray = arrayOf(3, 2, 1)
    val result = lilysHomework(inputArray)
    println("result: $result")
}