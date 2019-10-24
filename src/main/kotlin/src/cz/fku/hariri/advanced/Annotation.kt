package cz.fku.hariri.advanced

@Target(AnnotationTarget.CLASS)
annotation class Table(val name: String)

@Target(AnnotationTarget.PROPERTY)
annotation class Field(val name: String)

@Table(name = "CONTACT_TABLE")
data class Contact(val id: Int, @Field(name = "NAME") val name: String, val email: String)

fun main() {
    val annotation = Contact::class.annotations.find { it.annotationClass.simpleName == "Table" }
    println(annotation)
}