package com.example.programacionmultimediaydispositivosmoviles.t02_introduccion_a_kotlin.ejemplos_teoria.clases_y_objetos

import kotlin.math.PI

/**
 * Esto es un ejemplo de como crear una clase
 */

//Para que alguien pueda heredar de esta clase se le debe marcar como open
open class Aquarium (
    open var length: Int = 100,
    open var width: Int = 20,
    open var height: Int = 40
) {
    init {
        println("Inicializando aquarium");
    }

    open var volume: Int
        //GETTER
        get() = width * height * length / 1000;
        //SETTER
        set(value) { height = (value * 1000) / (width * length) }

    open val shape = "rectangle";

    open var water: Double = 0.0
        get() = volume * 0.9;

//Kotlin admite varios constructores PERO LA GUIA DE ESTILOS NOS DICE
//    QUE LAS CLASES DEBEN TENER SOLO UN CONSTRUCTOR
    constructor(numbreOfFish: Int) : this() {
        //2000 cm³ por pez + espacio extra para que el agua no se derrame
        val tank = numbreOfFish * 2000 * 1.1;
        height = (tank / (length * width)).toInt()
    }

    //Kotlin crea automaticamente getters and setters

    fun printSize(): Unit {
        println(shape);
        println("Width: $width " +
                "Length: $length " +
                "Height: $height ");
        println("Volume: $volume liters Water: $water liters (${water / volume * 100.0}% full)")
    }
}

class TowerTank (override var height: Int, var diameter: Int) : Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
    //ellipse area = π * r1 * r2
    get() = (width / 2 * length / 2 * height / 1000 * PI).toInt();
        set(value) {
            height = ((value * 1000 / PI) / (width/2 * length/2)).toInt();
        }

    override var water = volume * 0.8;
    override val shape = "cylinder";
}