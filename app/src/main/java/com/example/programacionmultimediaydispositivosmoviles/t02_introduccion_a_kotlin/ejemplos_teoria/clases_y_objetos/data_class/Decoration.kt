package com.example.programacionmultimediaydispositivosmoviles.t02_introduccion_a_kotlin.ejemplos_teoria.clases_y_objetos.data_class

data class Decoration(val rocks: String) {
}

data class Decoration2(val rocks: String, val wood: String, val diver: String) {
}

fun makeDecorations() {
    val decoration1 = Decoration("Granite");
    println(decoration1);
    val decoration2 = Decoration("Slate");
    println(decoration2);
    val decoration3 = Decoration("Slate");
    println(decoration3);

    println (decoration1.equals(decoration2));
    println (decoration3.equals(decoration2));

    val decoration4 = Decoration2("Crystal", "Wood", "Diver");
    println(decoration4);

    //Asi poemos deconstruir un objeto en Kotlin
    val(rock, wood, diver) = decoration4;
    println(rock);
    println(wood);
    println(diver);

//    Si no necesitas alguna propiedad al deconstruir lo puedes skipear con _
    val(rock2, _, diver2) = decoration4;
    println(rock2);
    println(diver2);
}

//Asi se declara un enum en kotlin
enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}



fun main() {
    makeDecorations();

    println(Color.RED.ordinal);
    println(Color.GREEN.name);
    println(Color.BLUE.rgb);
}