package cz.fku.hariri.advanced

// https://www.baeldung.com/kotlin-dsl
class SqlSelectBuilder {
    private val columns = mutableListOf<String>()
    private lateinit var table: String;
    fun select(vararg columns: String) {
        if(columns.isEmpty()) {
            throw IllegalAccessException("At least one column should be defined")
        }
        this.columns.addAll(columns)
    }

    fun from(table: String) {
        this.table = table
    }


    fun build(): String {
        if (!::table.isInitialized) {
            throw IllegalStateException("Failed to build an sql select - target table is undefined")
        }
        return toString()
    }

    override fun toString(): String {
        val columnsToFetch =
                if (columns.isEmpty()) {
                    "*"
                } else {
                    columns.joinToString(", ")
                }
        return "select $columnsToFetch from $table"
    }
}

fun query(initializer: SqlSelectBuilder.() -> Unit): SqlSelectBuilder {
    return SqlSelectBuilder().apply(initializer)
}


fun main() {
    val queryResult = query {
        select("c1", "c2")
        from("myTable")
    }

    println(queryResult)
}