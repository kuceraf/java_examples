package cz.fku.udemy.dataStructureAlgo

import kotlin.math.pow

/*
Radix Sort makes assumptions about the sorted data:
- all data must have the same number of characters = width
- data must be from discrete range = radix
 */
class RadixSort {
}

fun main() {
    val intArray = arrayOf(4725, 4586, 1330, 8792, 1594, 5729)
    radixSort(intArray, 10, 4)
    log(intArray)
}

fun radixSort(input: Array<Int>, radix: Int, width: Int) {
    for (i in 0 until width) {
        radixSingleSort(input, i, radix)
    }
}

fun radixSingleSort(input: Array<Int>, position: Int, radix: Int) {
    val numItems = input.size
    val countArray = IntArray(radix).toTypedArray()
    for (value in input) {
        // extract digit at specific position and increase number at countArray index
        countArray[getDigit(position, value, radix)]++
    }

    // adjust (sum up from left) the countArray
    for (j in 1 until radix ) {
        countArray[j] += countArray[j -1]
    }

    val temp = IntArray(numItems).toTypedArray()
    for (tempIndex in numItems-1  downTo 0) {
        // --countArray[getDigit(position, input[tempIndex], radix)]
        // save decremented value by 1 at index from getDigit and return the decremented value
        // the value is then used as index in temp
        temp[--countArray[getDigit(position, input[tempIndex], radix)]] =
            input[tempIndex]
    }
    // copy temp to original array
    for (tempIndex in 0 until numItems) {
        input[tempIndex] = temp[tempIndex]
    }
}

fun getDigit(position: Int, value: Int, radix: Int): Int {
    return value / 10.0.pow(position.toDouble()).toInt() % radix
}