package cz.fku.hariri.basic


data class Album (val name: String, val lenght: Int, val tracks: List<Track>)
data class Track (val name: String, val lenght: Int)

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

fun getTracks(): List<Pair<String,String>> {
    return albums.flatMap {
        val albumName = it.name;
        it.tracks
                .filter {it.lenght > 7}
                .map { Pair(albumName, it.name)}
    }
}

fun main() {
    println("start")
    getTracks().forEach { println(it.second)}
}