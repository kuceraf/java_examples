package cz.fku.hariri.functions

fun operation(a: Int, b: Int, op: (Int, Int) -> Int): Int {
    return op(a,b);
}

fun sum(a: Int, b: Int): Int {
    return a + b;
}

fun unaryOperation(x: Int, op: (Int) -> Int): Int {
    return op(x);
}

fun main(args: Array<String>) {
    val sumLambda = {a: Int, b: Int -> a + b} // lambda without type inference
    println(operation(1,2, ::sum)); // referencing function
    println(operation(1,2, {a,b -> a*b})); // lambda with type inference (it is in context)
    println(operation(1,2, sumLambda)); // lambda with type inference (it is in context)
    println(unaryOperation(3, {a -> a*a}))
    println(unaryOperation(3) {it * it}) // if last argument is function we can left it out from parenthesis (it helps when creating DSL)
    println(unaryOperation(4, fun(a: Int): Int {return a})) // anonymous function
}