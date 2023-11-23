package com.example.myprimerproyecto.syntaxis

fun main() {
    inmutableList()
}

fun mutableList() {
    val weekDays: MutableList<String> =
        mutableListOf("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo")
    weekDays.add(0, "JonasDay")
    println(weekDays)
}

fun inmutableList() {
    val readonly: List<String> =
        listOf("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo")
    // println(readonly.size)
    //println(readonly)

    //HACIENDO FILTRO DE LETRAS
    val example = readonly.filter { it.contains("martes") }
    println(example)

    //RECORRER
    //readonly.forEach { weekDay -> println(weekDay) }
}