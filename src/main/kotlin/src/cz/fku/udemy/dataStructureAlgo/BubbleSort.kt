package cz.fku.udemy.dataStructureAlgo

class BubbleSort {
}

fun main() {
    val intArray = arrayOf(20, 35, -15, 7, 55, 1, -22)

    for (lastUnsortedIndex in intArray.indices.reversed()) {
        for (i in 0 until lastUnsortedIndex) {
            if (intArray[i] > intArray[i + 1]) {
                swap(intArray, i, i + 1)
            }
        }
    }
    log(intArray)
}