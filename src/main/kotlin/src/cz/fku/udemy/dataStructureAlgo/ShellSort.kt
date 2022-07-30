package cz.fku.udemy.dataStructureAlgo

// vychazi z InsertionSort, ale navis se udela
// pre-order s vypoctenou gap
class ShellSort {
}

fun main() {
    val intArray = arrayOf(20, 35, -15, 7, 55, 1, -22)

    var gap = intArray.size / 2
    while (gap > 0) {
        println("Gap is $gap")
        for (i in gap until intArray.size) {
            val newElement = intArray[i]
            println("i: $i")
            println("newElement: $newElement")
            var j = i
            // shifting loop
            while (j >= gap && intArray[j - gap] > newElement) {
                println("j: $j")
                intArray[j] = intArray[j - gap]
                log(intArray)
                j -= gap
            }
            intArray[j] = newElement
        }
        gap /= 2
    }
    log(intArray)
}