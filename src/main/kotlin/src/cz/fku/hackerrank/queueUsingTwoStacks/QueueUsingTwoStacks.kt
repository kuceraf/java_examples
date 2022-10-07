package cz.fku.hackerrank.queueUsingTwoStacks

import java.util.*

/**
 * https://www.hackerrank.com/challenges/one-month-preparation-kit-queue-using-two-stacks
 */
class QueueUsingTwoStacks {
}

// inspired by https://www.geeksforgeeks.org/queue-using-stacks/
fun main(args: Array<String>) {
    val systemInput = Scanner(System.`in`)
    val queriesNo = systemInput.nextInt()
    val myQueue = Queue()

    for (queryNo in 1 .. queriesNo) {
        when (systemInput.nextInt()) {
            1 -> {
                myQueue.enqueue(systemInput.nextInt())
            }

            2 -> {
                myQueue.dequeue()
            }

            else -> println(myQueue.peek())
        }
    }
}

class Queue {
    private val s1 = Stack<Int>()
    private val s2 = Stack<Int>()


    fun enqueue(input: Int) {
        while (s1.isNotEmpty()) {
            s2.push(s1.pop())
        }
        s2.push(input)
        while (s2.isNotEmpty()) {
            s1.push(s2.pop())
        }
    }

    fun dequeue(): Int {
        return s1.pop()
    }

    fun peek(): Int {
        return s1.peek()
    }
}