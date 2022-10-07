package cz.fku.hackerrank

/**
 * https://www.hackerrank.com/challenges/one-month-preparation-kit-icecream-parlor/problem
 */
class IceCreamParlor {
}

fun main() {
    val result = icecreamParlor2(6, arrayOf(1, 2, 3, 4, 5, 6))
    println("${result[0]} ${result[1]}")
}

// O(n) optimized solution
fun icecreamParlor2(m: Int, arr: Array<Int>): Array<Int> {
    val map = mutableMapOf<Int, Int>()
    arr.forEachIndexed { i, flavourCost ->
        val restM = m - flavourCost
        if (map.containsKey(restM)) {
            return arrayOf(map[restM]!!, i + 1)
        }
        map[flavourCost] = i + 1
    }
    return emptyArray()
}

// O(n^2) solution
fun icecreamParlor1(m: Int, arr: Array<Int>): Array<Int> {
    // Write your code here
    for (i in 0..arr.size) {
        for (j in i + 1..arr.size) {
            if (m == arr[i] + arr[j]) {
                return arrayOf(i + 1, j + 1)
            }
        }
    }
    return arrayOf(0)
}