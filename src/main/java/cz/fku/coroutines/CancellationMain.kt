package cz.fku.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    println("runBlocking: ${Thread.currentThread().name}")
    // charPrinter("*")
    println()
    launch {
        println("*** runBlocking launch: ${Thread.currentThread().name}")
        charPrinter("#", 20)
    }
    launch {
        println("*** runBlocking launch: ${Thread.currentThread().name}")
        withTimeout(10000L) {
            try {
                charPrinter("@", 15)
            } catch (e: CancellationException) {
                println("FKU CancellationException")
            }
        }
    }
    launch {
        try {
            charPrinterWithError("&", 20)
        } catch (e: ArithmeticException) {
            println("FKU ArithmeticException")
        }
    }
    launch {
        charPrinterWithError("^", 20)
    }
//    val job = GlobalScope.launch {
//        charPrinterWithError("@")
//    }
    // job.join()
//    coroutineScope {
//        println("runBlocking coroutineScope: ${Thread.currentThread().name}")
//        launch(Dispatchers.IO) {
//            println("*** runBlocking coroutineScope launch: ${Thread.currentThread().name}")
//            charPrinter(".")
//        }
//    }
}

private suspend fun charPrinterWithError(string: String, times: Int = 8) {
    repeat(times) {
        delay(1000L)
        print(string)
        if (it > 3) throw ArithmeticException("Error when printing chars")
    }
}

private suspend fun charPrinter(string: String, times: Int = 5) {
    repeat(times) {
        delay(1000L)
        print(string)
    }
}
