package cz.fku.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch {
        charPrinter("*")
        charPrinter("#")
    }
    launch {
        charPrinter("A")
        charPrinter("B")
    }
}

private suspend fun charPrinter(string: String, times: Int = 5) {
    repeat(times) {
        delay(1000L)
        print(string)
    }
}
