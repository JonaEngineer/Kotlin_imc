package com.example.myprimerproyecto.syntaxis

fun main() {
    val weekDays = arrayOf("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo")
    println(weekDays.size)
    println(weekDays[6])

    //RECORRER ARRAYS CON BUCLES
    for (position in weekDays.indices) {
        //println("Hoy es: $position")
        // println(weekDays[position])

        //ESTO TE DA LA POSICION Y TAMBIEN EL VALOR
        for ((position, dia) in weekDays.withIndex()) {
            // println("La Posicion $position contiene el dia $dia")
        }

        //ACCEDE SOLO AL VALOR
        for (weekDay in weekDays) println("Hoy es $weekDay")
    }
}