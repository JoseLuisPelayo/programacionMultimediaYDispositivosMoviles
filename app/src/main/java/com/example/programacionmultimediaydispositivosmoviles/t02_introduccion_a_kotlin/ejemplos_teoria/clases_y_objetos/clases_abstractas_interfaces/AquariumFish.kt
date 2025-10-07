package com.example.programacionmultimediaydispositivosmoviles.t02_introduccion_a_kotlin.ejemplos_teoria.clases_y_objetos.clases_abstractas_interfaces

fun main() {
    makeFish();
}

fun makeFish() {
    val shark = Shark();
    val pleco = Plecostomus();

    println("Shark: ${shark.color}");
    shark.eat();
    println("Plecostomus: ${pleco.color}");
    pleco.eat();
}

////Creamos la clase abstracta y definimos una propiedad abstracta
//abstract class AquariumFish : FishAction {
//    abstract val color: String;
////    abstract override fun eat();
//}
//
interface FishAction {
    fun eat();
}

//class Shark(override val color: String = "Grey") : AquariumFish(), FishAction {
//    override fun eat() {
//        println("Hunt and eat fish");
//    }
//}

//Esta implementa dos interfaces en ved de una clase abstracta
//class Shark(override val color: String = "Grey") : FishColor, FishAction {
//
//    override fun eat() {
//        println("Hunt and eat fish");
//    }
//}

//class Plecostomus(override val color: String = "Gold") : AquariumFish(), FishAction {
//    override fun eat() {
//        println("Eat algae");
//    }


//Asi todos los peces seran dorados pero si vienen de otro colo
//podemos solucionarlo añadiendo como parametro la interfaz y la definicion
//class Plecostomus : FishColor by GoldColor, FishAction {
//    override fun eat() {
//        println("Eat algae");
//    }
//}

class Plecostomus(fishColor: FishColor = GoldColor) :
    FishAction by PrintingFishAction("Eat algae"),
    FishColor by fishColor;

class Shark() :
        FishAction by PrintingFishAction("Hunt and eat fish"),
        FishColor {
    override val color: String = "Grey"
        };

interface FishColor {
    val color: String;
}

//SINGLETON EN KOTLIN
object GoldColor : FishColor {
    override val color: String = "Gold";
}

object GreyColor : FishColor {
    override val color: String = "Grey";
}

//Inteface para delegar FishAction
class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food);
    }
}