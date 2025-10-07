package com.example.programacionmultimediaydispositivosmoviles.t02_introduccion_a_kotlin.ejemplos_teoria.clases_y_objetos.otras_clases

import com.example.programacionmultimediaydispositivosmoviles.t02_introduccion_a_kotlin.ejemplos_teoria.clases_y_objetos.clases_abstractas_interfaces.FishColor
import com.example.programacionmultimediaydispositivosmoviles.t02_introduccion_a_kotlin.ejemplos_teoria.clases_y_objetos.clases_abstractas_interfaces.GoldColor

//A veces se necesita una función o propiedad única asociada a una clase y no a una instancia.
// En otros lenguajes, como Java, se podría utilizar un miembro estático. Kotlin ofrece el objeto
// complementario para este fin. El objeto complementario no es una instancia y no está pensado
// para utilizarse por sí solo.

class Choice {
    companion object : FishColor by GoldColor {
        var name: String = "lyric"
        fun showDescription(name:String) = println("My favorite $name")
        fun showColor() = println(color);
    }
}

// Pare y triples son data clases prehechas que pueden tener 2 o 3 items genericos.
val equipment = "fish net" to "catching fish";

val numbers = Triple(6, 9, 42);

val equipment2 = ("fish net" to "catching fish") to "equipment";


fun main() {
    println(Choice.name)
    Choice.showDescription("pick")
    Choice.showDescription("selection")
    Choice.showColor();

    println("${equipment.first} used for ${equipment.second}");
    println(numbers.toList());
    println(numbers.toString());

    println("${equipment2.first} is ${equipment2.second}\n")
    println(equipment2.first.second)
}