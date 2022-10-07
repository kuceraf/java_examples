package cz.fku.udemy.dataStructureAlgo.hashtable

class SimpleHashtable {
}

fun main() {
    val stopIndex = 5
    var hashedKey = 6
    while (hashedKey != stopIndex) {
        println(hashedKey)
       hashedKey = (hashedKey + 1) % 15
    }
}