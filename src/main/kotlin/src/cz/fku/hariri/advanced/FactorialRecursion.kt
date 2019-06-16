package cz.fku.hariri.advanced



fun factorial(number: Int): Int {
    when(number) {
        0,1 -> return 1
        else -> return number * factorial(number -1)
    }
}

fun main() {
 println(factorial(4));
}