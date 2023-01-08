package cz.fku.hackerrank

// https://www.hackerrank.com/challenges/bigger-is-greater/forum
class BiggerIsGreater {
}

fun main() {
    // if its 1432 the immideate next is 2134
    // for hefg is expexted hegf
    // dhck -> dhkc (my cdhk)
    // 2314 -> 2341 (my 1234)
    "hefg".forEach { print("${it.toInt()} ") }
    println()
    "hegf".forEach { print("${it.toInt()} ") }
    println()

    println(
        biggerIsGreater("ba")
    )
}

fun biggerIsGreater(w: String): String {
    for (i in 0..w.length - 2) {
        if (w[i].toInt() > w[i + 1].toInt()) {
            val left = w.substring(IntRange(0, i+1)).toMutableList()
            val right = w.substring(IntRange(i + 2, w.length - 1))

            // swap the smallest char from right with the last element in left and sort the right
            val rightSorted = right.toCharArray().sorted().toMutableList()
            val tmp = rightSorted.first()
            rightSorted[0] = left.last()
            left[left.lastIndex] = tmp

            return left.joinToString("") + rightSorted.sorted().joinToString("")
        }
    }
    return "no answer"
}
//fun biggerIsGreater(w: String): String {
//    // Write your code here
//    for (i in w.length - 1 downTo 0) {
//        for (j in i - 1 downTo 0) {
////            println("comparing ${w[i]} - ${w[j]}")
//            if (w[i].toInt() > w[j].toInt()) {
//                // swap
//                val lower = w[j]
//                val sb = StringBuilder(w)
//                sb.replace(j, j+1, w[i].toString())
//                sb.replace(i, i+1, lower.toString())
//                return sb.toString()
//            }
//        }
//    }
//    return "no answer"
//}
