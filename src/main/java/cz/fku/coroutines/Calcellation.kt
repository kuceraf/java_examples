package cz.fku.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

fun main() = runBlocking {
    val job = launch(context = Dispatchers.Default) {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        }
        catch (ce: CancellationException) {
            withContext(NonCancellable) {

            }
            println("exception catched...")
        }
        finally {
            println("job: I'm running finally")
        }
    }
    delay(1300L) // delay a bit
    measureTimeMillis {  }
    println("main: I'm tired of waiting!")
    //job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}