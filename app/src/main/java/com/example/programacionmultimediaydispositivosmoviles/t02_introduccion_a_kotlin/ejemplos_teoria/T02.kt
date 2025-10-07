package com.example.programacionmultimediaydispositivosmoviles.t02_introduccion_a_kotlin.ejemplos_teoria

import java.util.*

fun main() {
    //Los comentarios son como en java // para linea /* para bloque

    //Asignación de variables
    // si no le pones tipo kotlin lo asigna solo
    val variableNumerica = 3;

    //Pero puedes tiparlas al declararlas
    val variableTexto: String;

    //Imprimir una suma sencilla por consola
    println(variableNumerica + variableNumerica);


    //***** TIPOS DE DATOS *****
    // CHAR
    // Entre comilla simples
    //
    // Literal
    val caracterLiteral: Char = 'H';

    //Caracter especial (debe ir precedido por \)
    val caracterEspecial: Char = '\"';

    // INT
    //Hasta 32 bits
    val numeroEntero: Int = 1234567899;

    // LONG
    //Hasta 64bits
    val numeroGrande: Long = 2342342432424355234;

    // SHORT
    //Hasta 16bits
    val numeroPequeño: Short = 12345;

    // BYTE
    //Hasta 8 bits
    val numeroMini: Byte = 127;

    //FLOAT
    //Hasta 32 bits 6-7 decimales Si no tipas la variable el compilador declarará un Double
    val numeroDecimalSimple: Float = 24.123455F;

    //DOUBLE
    //Hasta 64bits 12-14 decimales
    val numeroDecimalDoble: Double = 24.12345678912322;

    //BOOLEAN
    val boleano: Boolean = true;

    //STRING
    //Entre comillas dobles
    val cadenaTexto: String = "Hola caracola 65";

    //Se pueden escribir cadenas de texto de más de una línea usando """
    val cadenaLiteralMultilinea: String = """
        |Puedo escribir en varias lineas
        |linea 1
        |linea 2
        |linea 3
    """;
    println(cadenaLiteralMultilinea);

//***** VARIABLES VS VALORES *****
    // Las variables pueden ser reasignadas pero los valores no.
    var variableDeEjemplo = "";
    variableDeEjemplo = "Le cambio el valor y no hay problema";

    val valorDeEjemplo = "Caracola";
    // valorDeEjemplo = "Otra cosa"; //Si descomentas esto da error por que no se puede reasignar


//***** Declaración de funciones *****
    // Para declarar una función se usa la palabra clave fun
    fun nombreDeLaFuncion(argumento1: String, argumento2: Int): Unit { // Unit es el tipo de retorno de la función
                                                                       // sería como un void en Java
        //Cuerpo de la funcion
        println("$argumento1 $argumento2");
    }

    //Si una función devuelve únicamente una expresión, podemos reducir su sintaxis
    //a una función con cuerpo de expresión.
    fun calcularVelocidad(metros: Double, segundos: Double) = metros/segundos;

    val velocidadEjemplo = calcularVelocidad(150.235, 3.233);
    println("Velocidad = $velocidadEjemplo metros/segundo");

    //Kotlin nos permite deﬁnir argumentos con valores por defecto y nombrados.
    fun calcularPrecioConIva(precio: Double, iva: Int) = precio + precio * (iva / 100.0);

    //Con un precio de 100 euros y un iva del 21 debería darnos 121
    println(calcularPrecioConIva(100.000000, 21));

    //Podemos ponerle el iva por defecto de la siguioente manera
    fun calcularPrecioConIva2(precio: Double, iva: Int = 21) = precio + precio * (iva/100.0);
    //Ahora solo con ponerle el precio serviriía
    println("\n" + calcularPrecioConIva2(100.00));

    //Pero ahora hay un dia sin iva, no pasa nada le pasamos el parametro
    println(calcularPrecioConIva2(100.00, 0));

    //¿Y si tuvieramos el precio por defecto tambien?
    fun calcularPrecioConIva3(precio: Double = 100.00, iva: Int = 21) = precio + precio * (iva/100.0);
    println("\n" + calcularPrecioConIva3());
    //Al llamar a la función tendriamos que nombrar la variable que quisieramos reasignar
    println(calcularPrecioConIva3(precio = 200.0));

//***** Condicionales *****
    //IF/ELSE
    //El condicional if es exactamente igual que en java
    val age = 18;

    if (age >= 18)
       println("\nEres mayor de edad");
    else
       println("\nEres menor de edad");

    //WHEN (SWITCH)
    var notaExamen = 8;

    println(when (notaExamen) {
        1,2,3,4 -> "Suspendido";
        5 -> "suficiente";
        6,7 -> "Bien";
        8 -> "Notable";
        9,10 -> "Sobre"
        else -> "Nota invalida"
    })

    //En Kotlin puedes tener switch con rangos
    val notaEjemplo = 8.00
    when(notaEjemplo) {
        in 0.0..4.99 -> println("Suspendido");
        in 5.0..5.99 -> println("Suficiente");
        in 6.0..7.99 -> println("Bien");
        in 0.0..4.99 -> println("Notable");
        in 0.0..4.99 -> println("Sobresaliente");
        else -> println("Nota inválida")
    }

    //Se pueden comparar tipos con el operador is
    when(notaEjemplo) {
        is Int -> println("Es entero");
        is Double -> println("Es Doble");
        is Float -> println("Es Flotante");
        is String -> println("Es una cadena");
        else -> println("Es otro tipo de dato");
    }

    //Podemos comprobar expresiones booleanas sin tener un parámetro de comparación
    when {
        notaEjemplo < 5 && notaEjemplo >=0 -> println("Suspendido");
        notaEjemplo < 6 -> println("Suficiente")
        notaEjemplo < 8 -> println("Bien")
        notaEjemplo < 9 -> println("notable")
        notaEjemplo < 10 -> println("Sobre")
    }

    //Cabe la posibilidad de pasar una variable en el argumento de when y con tal ﬁn se
    //tiene que crear una expresión de asignación a una variable no mutable
    val factorSuerte = 0.2
    val bonus = 0.3
    when (val damage: Double = factorSuerte + bonus) {
        in 0.0..0.3 -> println("Daño recibido:${damage * 10}")
        in 0.3..0.6 -> println("Daño recibido:${damage * 20}")
        in 0.6..1.0 -> println("Daño recibido:${damage * 30}")
    }

    //Casi todo en kotlin tiene un valor aunque sea Unit
    val isUnit = println("valor del print");
    println(isUnit);

    val celsius = 10;
    val isHot = if (celsius > 50) true else false;
    println(isHot);

    println("La temperatura del agua es ${ if (celsius > 50) "muy caliente" else "OK" }");


    // Funciones
    fun randomDay(): String {
        val week = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo");
        return week[Random().nextInt(week.size)]
    }

    fun fishFood(day: String): String {
        var food = "";

        food = when (day) {
            "Lunes" -> "cereales"
            "Martes" -> "pellets"
            "Miércoles" -> "gusanos rojos"
            "Jueves" -> "granos"
            "Viernes" -> "mosquitos"
            "Sábado" -> "lechuga"
            "Domingo" -> "plankton"
            else -> "Día erroneo"
        }

            return food;
        }

    //Funciones compactas
//    fun shouldChangeWater(day: String, temp: Int = 22, dirty: Int = 20): Boolean {
//        return when {
//            temp > 30 -> true;
//            dirty > 30 -> true;
//            day == "Domingo" -> true;
//            else -> false
//        }
//    }

    fun isTooHot(temp: Int): Boolean = temp > 30;
    fun isTooDirty(dirty: Int): Boolean = dirty > 30;
    fun isSunday(day: String): Boolean = day == "Domingo";

    fun shouldChangeWater(day: String, temp: Int = 22, dirty: Int = 20): Boolean {
        return when {
            isTooHot(temp) -> true;
            isTooDirty(dirty) -> true;
            isSunday(day) -> true;
            else -> false
        }
    }

        fun feedTheFish(): Unit {
        val day = randomDay();
        val food =fishFood(day)

        println("Hoy es $day y el pez come $food");
        println("Cambiar el agua: ${shouldChangeWater(day)}");
    }

    feedTheFish();

}
