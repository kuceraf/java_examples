package cz.fku.hariri.advanced



fun factorial(number: Int): Int {
    return when(number) {
        0,1 -> 1
        else -> number * factorial(number -1)
    }
}

fun main() {
 println(factorial(4));
}