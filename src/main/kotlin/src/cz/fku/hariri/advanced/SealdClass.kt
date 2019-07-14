package cz.fku.hariri.advanced

/**
 * Sealed key word is Kotlin support for "Algebraic Data Types" (https://www.quora.com/What-is-an-algebraic-data-type)
 *
 * Sealed classed are, in a sense, an extension of enum classes: the set of values for an enum
 * type is also restricted, but each enum constant exists only as a single instance, whereas a
 * subclass of a sealed class can have multiple instances which can contain state.
 */
sealed class SearchResult
class Success(val data: List<String>): SearchResult()
class Error(val code: String, val message: String): SearchResult()

fun doSearch(): SearchResult {
    return Success(listOf("result"))
}

fun main() {
    when(val result = doSearch()) {
        is Success -> println("Found it: ${result.data}")
        is Error-> println("Search failed")
    }
}