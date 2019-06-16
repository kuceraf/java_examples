package cz.fku.hariri.basic


fun main() {
    val albums: List<Album> = listOf(
            Album("aaa", 60, listOf(
                    Track("a1",10),
                    Track("a2",2),
                    Track("a3",7)
            )),
            Album("bbb", 64, emptyList()),
            Album("ccc", 80, listOf(
                    Track("c1",5),
                    Track("c2",9)
            ))
    )

    with(albums.get(0)) {
        println(name) // access the property of album here
        println(tracks)
    }

    val myString: String? = "oooo"
    myString?.let { println(it.length) } // myString is nullable, apply let function block only if is not null
}