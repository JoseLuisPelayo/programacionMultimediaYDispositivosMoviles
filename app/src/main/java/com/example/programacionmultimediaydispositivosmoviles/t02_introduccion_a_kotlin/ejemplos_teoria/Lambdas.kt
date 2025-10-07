package com.example.programacionmultimediaydispositivosmoviles.t02_introduccion_a_kotlin.ejemplos_teoria

fun main() {

//    ********************** FUNCIÒN LAMBDA ******************************
    var dirtyLevel: Int = 20;

// Puedes guardar una funcion lambda en una variable y reutilizarla más tarde
//    Los argumentos de la funcion van antes de la ->

//Variable que guarda la funcion: (tipo que recibe) -> Tipo que rtorna = { codigo de la funcion, retornara el resultado de lo que haya dentro }
    var waterFilter: (Int) -> Int = { dirty -> dirty / 2 };

    println(waterFilter(dirtyLevel));


    //    ********************** FUNCIÓN DE ORDEN SUPERIOR ******************************
//    Una función de orden superior es una funcion que toma otras funciones como
//    parametro o que devuelve otra función como retorno


//    Le pasas como párametro un int llamado dirty y una función que recibe un int llamada hof
//    Devuelve el resultado de la función hof pasandole a esta dirty como argumento
    fun updateDirty(dirty: Int, function: (Int) -> Int): Int {
        return function(dirty);
    }

    println(updateDirty(30, waterFilter));

//    La función que le pases como argumento a una HOF no tiene que ser una lambda,
//    puede ser una función normal

    fun increaseDirty( start: Int ): Int {
        return start + 1;
    }

    println(updateDirty(15, ::increaseDirty));

//    Kotlin tiene una sintaxis especial para las funciones de orden superior
//    LLamada Last Parameter Call Syntax
//    Te permite pasar una lambda como parámetro de la función sin meterla en los paréntesis
    dirtyLevel = 19;

    dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel +23};

    println(dirtyLevel);






}
