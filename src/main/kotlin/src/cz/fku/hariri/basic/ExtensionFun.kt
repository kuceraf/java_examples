package cz.fku.hariri.basic

fun String.toTitleCase(): String {
    return this.split(" ").joinToString(" "){it.capitalize()};
}

fun main(args: Array<String>) {
    println("a text to titlce case".toTitleCase());
}