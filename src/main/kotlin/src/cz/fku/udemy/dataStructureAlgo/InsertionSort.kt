package cz.fku.udemy.dataStructureAlgo

class InsertionSort {
}

fun main() {
    val intArray = arrayOf(20, 35, -15, 7, 55, 1, -22)
    for (firstUnsortedIndex in 1 until intArray.size) {
        val newElement = intArray[firstUnsortedIndex]
        var i = firstUnsortedIndex

        while (i > 0 && intArray[i - 1] > newElement) {
            // shifting
            intArray[i] = intArray[i - 1]
            log(intArray)
            i--
        }
        intArray[i] = newElement
    }
    println("result")
    log(intArray)
}