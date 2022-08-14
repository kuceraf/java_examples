package cz.fku.udemy.dataStructureAlgo

class SortUtils {
}

fun log(array: Array<Int>) {
    println(array.joinToString(separator = " "))
}

fun log(message: String, array: Array<Int>) {
    println(message +" "+array.joinToString(separator = " "))
}

fun swap(array: Array<Int>, i: Int, j: Int) {
    val tmp = array[i]
    array[i] = array[j]
    array[j] = tmp
}