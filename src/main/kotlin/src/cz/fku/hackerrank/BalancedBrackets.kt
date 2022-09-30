package cz.fku.hackerrank

import java.util.*

/**
 * https://www.hackerrank.com/challenges/one-month-preparation-kit-balanced-brackets/problem
 */
fun main() {
// Balanced Brackets
    val s = "}][}}(}][))]"
    val balanced = IsBalancedComputation.isBalanced(s);
    println(balanced)
}

object IsBalancedComputation {
    private val mapping = mapOf(
        '{' to '}',
        '[' to ']',
        '(' to ')'
    )

    fun isBalanced(s: String): Boolean {
        if (s.isEmpty() || s.length % 2 != 0) {
            return false
        }
        val stack: Deque<Char> = LinkedList()
        s.forEach {
            if (mapping.containsKey(it)) {
                stack.push(it)
            } else {
                val latestOpenP = stack.poll()
                if (latestOpenP == null || mapping[latestOpenP] != it) {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}
