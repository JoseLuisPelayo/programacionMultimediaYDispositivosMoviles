package com.example.programacionmultimediaydispositivosmoviles.t02_introduccion_a_kotlin.ejemplos_teoria

fun main() {
    println( decorations.filter { it[0] == 'p' } );

    //En kitlin los filtros pueden ser eager o lazy
    //eager crean una nueva lista
    val eager = decorations.filter { it[0] == 'p' };
    println("Eager: $eager");

    //Si la guardas como lazy la guardas como una secuencia
    val filtered = decorations.asSequence().filter { it[0] == 'p' };
    println("Filtered: $filtered");

    //Forzar la evaluación
    val newList = filtered.toList();
    println("Nueva lista: $newList");

    val lazyMap = decorations.asSequence().map {
        println("access: $it");
        it;
    }

    println("lazy: $lazyMap");
    println("-----");
    println("First: ${lazyMap.first()}");
    println("-----")
    println("All: ${lazyMap.toList()}");


    //Flatten es como un merge
    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities)     // list of lists
    println("-----")
    println("Flat: ${mylist.flatten()}")
}

val decorations: List<String> = listOf(
    "rock",
    "pagoda",
    "plastic plant",
    "alligator",
    "flowerpot"
);
