package cz.fku.udemy.dataStructureAlgo

class MergeSort {
}

fun main() {
    val intArray = arrayOf(20, 35, -15, 7, 55, 1, -22)
    mergeSort(intArray, 0, intArray.size)
    log(intArray)
}

fun mergeSort(input: Array<Int>, start: Int, end: Int) {
    if (end - start < 2) {
        return
    }

    val mid = (start + end) / 2
    mergeSort(input, start, mid)
    mergeSort(input, mid, end)
    merge(input, start, mid, end)
}


fun merge(input: Array<Int>, start: Int, mid: Int, end: Int) {
    printArray(start, end, input, mid)
    val tmpArray = IntArray(end - start)
    var i = start
    var j = mid
    var tmpIndex = 0

    while (i < mid && j < end) {
        tmpArray[tmpIndex++] = if(input[i] <= input[j]) {
            input[i++]
        } else {
            input[j++]
        }
    }
    System.arraycopy(input, i, input, start + tmpIndex, mid - i)
    System.arraycopy(tmpArray.toTypedArray(), 0, input, start, tmpIndex)
}

private fun printArray(start: Int, end: Int, input: Array<Int>, mid: Int) {
    val sb = StringBuilder()
    for (i in start until end) {
        sb.append(input[i])
        sb.append(" ")
        if (i == mid - 1) {
            sb.append("|")
            sb.append(" ")
        }
    }
    println(sb)
}