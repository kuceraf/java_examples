package cz.fku.hariri.advanced

import kotlin.reflect.KParameter
import kotlin.reflect.full.memberProperties

data class Transaction(val id: Int, val amount: Double, val description: String) {
    fun validate() {
        if(amount > 10000) {
            println("to large")
        }
    }
}

fun interspectInstanceJava(obj: Any) { // java API for reflection
    println("Class ${obj.javaClass.simpleName}")
    println("\nProperties:")
    obj.javaClass.declaredFields.forEach {
        println("${it.name} of type ${it.type}")
    }
    println("\nFunctions:")
    obj.javaClass.declaredMethods.forEach {
        println("${it.name}")
    }
}

fun interspectInstanceKotlin() {
    val classInfo = Transaction::class

    classInfo.memberProperties
            .forEach { println("Property ${it.name} of type ${it.returnType}")}

    // create instance of Transaction using reflection
    val constructor = ::Transaction
    val idParam: KParameter = constructor.parameters.first { it.name == "id" }
    val transaction = constructor.callBy(
            mapOf(idParam to 2, constructor.parameters[1] to 4000.0, constructor.parameters[2] to "My desc")
    )

    println(transaction)
}

fun main() {
    println(Transaction::javaClass)
    println(Transaction::class)

//    interspectInstanceJava(Transaction(3, 5000.0,  "Simple transaction"))
    interspectInstanceKotlin()
}