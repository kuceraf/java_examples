package cz.fku.hariri.basic

class LazyEveluation {
}

fun main() {
    //eagerEval()
    //lazyEval()
    lazyEval2()

}

private fun lazyEval2() {
    val elements = 1..1000_000_000_0
    elements.asSequence().filter { it < 30 } //  similar to java streams
            .forEach { println(it) }
}

private fun lazyEval() {
    val generateSequence = generateSequence(1) { x ->
        x * 10
    }

    generateSequence.take(15).forEach {
        // 2147483647 int max value
        // 276447232
        println(it)
    }
}

private fun eagerEval() {
    val elements = 1..1000_000_000_0
    // eager evaluation
    // waits till whole list is filtered and than it prints the results
    val output = elements.filter { it < 30 }
    output.forEach({ println(it) })
}