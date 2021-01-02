package cz.fku.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val duration = measureTimeMillis {
            val one = async { doSomethingUsefulOne() }
            val two = async { doSomethingUsefulTwo() }
            println("result is ${one.await() + two.await()}")
        }
        println("Completed in $duration ms")

        launch {
            val durationLaunch = measureTimeMillis {
                val one = launch { doSomethingUsefulOne() }
                val two = launch { doSomethingUsefulTwo() }
            }
            println("launch Completed in $durationLaunch ms")
        }
    }
}

suspend fun doSomethingUsefulOne(): Int {
    delay(2000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}
