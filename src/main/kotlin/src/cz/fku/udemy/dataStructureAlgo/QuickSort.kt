package cz.fku.udemy.dataStructureAlgo

class QuickSort {
}

fun main() {
    val intArray = arrayOf(20, 35, -15, 7, 55, 1, -22)
    quickSort(intArray, 0, intArray.size)
    log(intArray)
}

fun quickSort(intArray: Array<Int>, start: Int, end: Int) {
    if (end - start < 2) { // one element array --> return
        return
    }
    val pivotIndex = partition(intArray, start, end) // pivotIndex = element sorted position
    quickSort(intArray, start, pivotIndex)
    quickSort(intArray, pivotIndex + 1, end)
}

fun partition(input: Array<Int>, start: Int, end: Int): Int {
    // this is using the first element as the pivot
    var pivot = input[start]
    var i = start
    var j = end
    println("Partition start")
    while (i < j) {
        println("Outer while i:$i j:$j")
        // traverse from right to left
        // --j --> prefix decrement firstly decrement j and then use the result as index
        while (i < j && input[--j] >= pivot) { // find j index of the first element that is less than the pivot
        }
        if (i < j) {
            println("Right to left replace i:$i j:$j")
            input[i] = input[j] // place element less than the pivot left
            log(input)
        }

        // traverse from left to right
        while (i < j && input[++i] <= pivot) {
        }
        if (i < j) {
            println("Left to right replace i:$i j:$j")
            input[j] = input[i]
            log(input)
        }
    }
    println("Pivot index $j")
    input[j] = pivot
    return j
}