package cz.fku.udemy.dataStructureAlgo

class InsertionSort {
}

fun main() {
    val intArray = arrayOf(20, 35, -15, 7, 55, 1, -22)
//    iterativeInsertion(intArray)
    recursiveInsertion(intArray, 1)
    log(intArray)
}

private fun recursiveInsertion(intArray: Array<Int>, firstUnsortedIndex: Int) {
    if (firstUnsortedIndex >= intArray.size) {
        return
    }
    val newElement = intArray[firstUnsortedIndex]
    var i = firstUnsortedIndex

    while (i > 0 && intArray[i - 1] > newElement) {
        // shifting
        intArray[i] = intArray[i - 1]
        log(intArray)
        i--
    }
    intArray[i] = newElement
    recursiveInsertion(intArray, firstUnsortedIndex + 1)
}


private fun iterativeInsertion(intArray: Array<Int>) {
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
    println("result iterative")
    log(intArray)
}