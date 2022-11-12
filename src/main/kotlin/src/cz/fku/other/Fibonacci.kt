package cz.fku.other

import java.util.concurrent.ConcurrentHashMap

class Fibonacci {
    // dynamic programming cache
    private val cache = ConcurrentHashMap<Int, Int>()
    fun fibonacci(n: Int, s: String): Int {
        println("$s: $n")
        if (n <= 1) {
            return n // 0,1
        }

//        return cache.computeIfAbsent(n) {
//            fibonacci(n - 1, "left") + fibonacci(n - 2, "right")
//        }
        return when {
            cache.containsKey(n) -> cache[n]!!
            else -> {
                cache[n] = fibonacci(n - 1, "left") + fibonacci(n - 2, "right")
                cache[n]!!
            }
        }
    }
}

fun main() {
    println(Fibonacci().fibonacci(3, "start"))
}