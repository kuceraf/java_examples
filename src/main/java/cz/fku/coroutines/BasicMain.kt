package cz.fku.coroutines

import kotlinx.coroutines.*
import java.security.AccessControlContext
import kotlin.coroutines.CoroutineContext

fun main() = runBlocking {
    println("runBlocking start")
    launch(CoroutineName("FKU 1")) {
        println("launch 1 start")
        doWork("LAUNCH 1", 2000L, coroutineContext)
        launch(CoroutineName("FKU 1.1")) {
            doWork("LAUNCH 1.1", 5000L, coroutineContext)
        }
        launch(CoroutineName("FKU 1.2")) {
            doWork("LAUNCH 1.2", 1000L, coroutineContext)
        }
        println("launch 1 end")
    }

    println("...")

    launch(CoroutineName("FKU 2")) {
        doWork("LAUNCH 2", 1000L, coroutineContext)
    }
    println("runBlocking end")
}


suspend fun doWork(text: String, ms: Long, context: CoroutineContext) {
    println("$text - Inner context is: $context")
    delay(ms)
}
