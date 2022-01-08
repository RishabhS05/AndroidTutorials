package com.example.androidbasics

fun main() {
//    instance of a class
    val initBloc = InitBlock()
}

/**class syntax*/
class Text {}

// if class has no body
class A

/** constructors*/

//a class can have one primary constructor and more than one secondary constructors
class Test(message: String) {}

class MoreConstructors constructor(message: String) {
    // If the primary constructor have any annotations or visibility modifiers(private,protected, default,) than use constructor keyword.
    var number: Int = 0;

    //more than one constructor

    //    Delegation of another constructor of the same class is done using the this keyword:
//    secondary constructor
    constructor(message: String, number: Int) : this(message) {
        this.number = number
    }
}
//default params
//we can add default values as follows

class Params(message: String = "", number: Int)

/**Note
 * if all the params of primary constructor have default values,
 * JVM will generate an additional parameterless constructor which will use the default values
 * */


//If the constructor has annotations or visibility modifiers, the constructor keyword is required and the modifiers go before it:

class Modifiers public constructor() {
    //...
}

/**Init block in class */

/** Note :
 * Code in initializer blocks effectively becomes part of the primary constructor.
 * Delegation to the primary constructor happens as the first statement of a secondary constructor,
 * so the code in all initializer blocks and property
 * initializers is executed before the body of the secondary constructor. */
//init blocks execute as the are written in side the class top to  bottom.
class InitBlock {
    //    the primary constructor cannot contain any code. Initialization code can be placed in initializer blocks prefixed with the init keyword
    init {
        //its similar as static initializer block in java.
//During the initialization of an instance, the initializer blocks are executed in the same order as they appear in the class body, interleaved with the property initializers:
        println("First init")
    }

    init {
        println("second init")
    }

    constructor() {
        println("Primary Constructor")
    }
}

/** Next Inheritance
* */