package cz.fku.udemy.dataStructureAlgo

class SelectionSort {
}

fun main() {
    val intArray = arrayOf(20, 35, -15, 7, 55, 1, -22)
    for (lastUnsortedIndex in intArray.indices.reversed()) {
        var largestNumberIndex = 0
        for (i in 1 until lastUnsortedIndex) {
            if (intArray[i] > intArray[largestNumberIndex]) {
                largestNumberIndex = i
            }
        }
        swap(intArray, largestNumberIndex, lastUnsortedIndex)
    }
    log(intArray)
}