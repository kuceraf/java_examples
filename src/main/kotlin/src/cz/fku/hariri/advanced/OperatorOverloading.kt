package cz.fku.hariri.advanced

data class Time(val hours: Int, val mins: Int) {
    // it is possible to override only predefined operator
    operator fun plus(time: Time): Time { // it adds the + operator
        val totalMinutes = this.mins + time.mins
        val newHours = totalMinutes / 60
        val remainingMinutes = totalMinutes % newHours
        return Time(newHours + this.hours, remainingMinutes)
    }
}


fun main() {
    val time = Time(4, 20) + Time(1, 40)
    println(time)
}