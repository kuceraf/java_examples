package cz.fku.hariri.functions

fun String.toTitleCase(): String {
    return this.split(" ").joinToString(" "){it.capitalize()};
}

fun main(args: Array<String>) {
    println("a text to titlce case".toTitleCase());
}