package cz.fku.udemy.dataStructureAlgo.binarysearch

class BinarySearch {
}

/**
 [0,1,2,3,4]
 s=0, e=5 (array size)
 1) ----------------
 midpoint = (0+5)/2 = 2
 [0,1,*2*,3,4]
 left: [0,1] -> s=0, e=2
 right: [3,4] -> s=3, e=5
 2) ----------------
 [0,1,2,|3,4] -> s=3, e=5
 midpoint = (3+4)/2 = 3
 [0,1,2,|*3*,4]


 [0,1,2,3,4,5]
 s=0, e=6 (array size)
 midpoint = (0+6)/2 = 3
 [0,1,2,*3*,4,5]
 left: [0,1,2] -> s=0, e=3
 right: [4,5] -> s=4, e=5
 */
fun main() {
    val input = arrayOf(-20, -8, 0, 15, 55, 100)
    println(
        search(input, 0, 0, input.size)
    )
}

fun search(input: Array<Int>, find: Int, start: Int, end: Int): Int {
    val midPoint = (start + end) / 2
    println("Processing [$start, $midPoint, $end]")

    if (midPoint < 0 || midPoint > input.size - 1) {
        return -1
    }

    return if (find == input[midPoint]) {
        midPoint
    } else if (find > input[midPoint]) {
        println("Going right [${midPoint +1}, $end]")
        search(input, find, midPoint + 1, end)
    } else {
        println("Going left [${start}, $midPoint]")
        search(input, find, start, midPoint)
    }
}