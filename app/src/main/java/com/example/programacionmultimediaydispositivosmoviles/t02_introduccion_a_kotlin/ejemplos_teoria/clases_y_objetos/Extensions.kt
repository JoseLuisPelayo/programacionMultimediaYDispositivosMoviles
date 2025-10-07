package com.example.programacionmultimediaydispositivosmoviles.t02_introduccion_a_kotlin.ejemplos_teoria.clases_y_objetos

fun String.hasSpaces(): Boolean {
    val found = this.indexOf(' ');
    return found != -1;
}