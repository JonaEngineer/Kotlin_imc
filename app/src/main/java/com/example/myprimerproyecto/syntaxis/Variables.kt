package com.example.myprimerproyecto.syntaxis

fun main() {
   add(10, 10) //Parametros de entrada

   val mySubtract = subtract(20, 10) //Parametros de salida
    println(mySubtract)
}
fun add(firstNumber:Int, secondNumber:Int){
    println(firstNumber + secondNumber)
}
fun subtract(firstNumber: Int, secondNumber: Int):Int{
   return firstNumber - secondNumber
}
//segunda forma de hacer subtract de manera corta
fun subtractCorto(firstNumber: Int, secondNumber: Int):Int =firstNumber - secondNumber
