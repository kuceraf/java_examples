package cz.fku.hariri.functions

fun main(args: Array<String>) {
    val baseClass: BaseClass = BaseClass();
    baseClass.extension()
    val inheritedClass: InheritedClass = InheritedClass()
    inheritedClass.extension()
}

open class BaseClass
class InheritedClass : BaseClass()

fun BaseClass.extension() {
    println("Base extension")
}

fun InheritedClass.extension() {
    println("Inherited extension")
}