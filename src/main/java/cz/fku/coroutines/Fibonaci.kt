package cz.fku.coroutines

import kotlinx.coroutines.*

class Fibonaci {
}

fun main() {
    val job = GlobalScope.launch(Dispatchers.Default) {
        delay(3000L)
        println("Starting long running calculation...")
        (30..45).forEach { i ->
            println("Thred: ${Thread.currentThread().name} ${Thread.currentThread().id} --> Fib number for $i is ${fib(i)}")
        }
        println("Ending long running calculation...")
    }

    runBlocking {
        job.join()
    }
}

fun fib(n: Int): Long {
    return when (n) {
        0 -> 0
        1 -> 1
        else -> fib(n - 1) + fib(n - 2)
    }
}