package cz.fku.udemy.dataStructureAlgo

class CountingSort {
}

fun main() {
    val orig = arrayOf(2, 5, 9, 8, 2, 8, 7, 10, 4, 3)
    val countArray = IntArray(orig.size).toTypedArray()
    orig.forEachIndexed { i, e ->
        countArray[e - 1] = ++countArray[e - 1]
    }
    var origPointer = 0
    countArray.forEachIndexed { i, e ->
        var eVar = e
        while (eVar > 0) {
            orig[origPointer] = i+1
            origPointer++
            eVar--
        }
    }
    log("countArray", countArray)
    log("orig", orig)
}