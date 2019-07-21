package cz.fku.hariri.advanced

class BoxReadOnly<out T> (val item: T) {
    fun readItem(): T {
        return item
    }
}

fun main() {
    val box = BoxReadOnly<String>("A")
    val readItem: String = box.readItem()
}