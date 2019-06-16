package cz.fku.hariri.advanced

fun containingFunction() {
    val mySequence = 1..100

    // 1) USING RETURN FROM LAMBDA EXPRESION
    mySequence.forEach {
        if(it == 20) {
            return@forEach // local return - it returns only from forEach loop
                           // without local return it returns to closest fun key word
        }
    }
    println("hello1")
}

fun containingFunction2() {
    val mySequence = 1..100

    // 2) USING RETURN FROM ANONYMOUS FUNCTION
    mySequence.forEach(fun (mySequence) {
        if(mySequence == 20) {
            return  // it returns to the closest fun key word
        }
    })
    println("hello2")
}

fun main() {
    containingFunction()
    containingFunction2()
}