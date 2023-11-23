package com.example.myprimerproyecto.syntaxis

fun main(){
    ifBasic()
}
fun ifBasic(){
   val name:String="Jonathan"
    if (name!= "Jonathan") {
        println("Nombre incorrecto")
    }
    else if (name=="Jonathan"){
        println("Bienvenido $name. Es un placer tenerte por aqui")
    }
}