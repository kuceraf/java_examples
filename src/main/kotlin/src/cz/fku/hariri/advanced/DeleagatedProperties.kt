package cz.fku.hariri.advanced

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Customer {
    // delegating calls to name properties getters and setters to "MyDelegate" object
    var name: String by MyDelegate()
    var observableName: String by Delegates.observable("default", {property, oldValue, newValue ->
        println("Property ${property.name} has changed from ${oldValue} to ${newValue}")
    })

}

class MyDelegate{
    var backingNameField: String = "default"
    operator fun getValue(customer: Customer, property: KProperty<*>): String {
        return backingNameField
    }

    operator fun setValue(customer: Customer, property: KProperty<*>, s: String) {
        backingNameField = s;
    }
}

fun main() {
    val customer = Customer()
    customer.name = "Pepa"
    println(customer.name);

    customer.observableName = "Filip"
}