package com.example.androidbasics

fun main(){
//     Data class Copy function call
    val jack = User(name = "Jack", age = 1)
//    create copy of old object
    val olderJack = jack.copy(age = 2)
//  Component function

    val j = User("Rishabh", 0)
    val (name, age) = jane
    println("$name $age")
}

/**
 * Sealed class
 * 1 Sealed classes or interfaces are abstract by default.
 * 2 Sealed classes are similar to enum class, enum constant exists only as single instance,
 * where a sub class of a sealed class have multiple instances
 * 3 Constructors of sealed classes can have one of two visibilities: protected (by default) or private
 * 4 Direct subclass of sealed class and interface must be declared in the same package.
 * 5 enum classes can't extend a sealed class (as well as any other class), but they can implement sealed interfaces.
 * */
sealed class Error
open class FileReadError : Error()
class DatabaseError : Error()
class RuntimeError : Error()

/**
 * sealed class benefit , when using 'when' expression
 *this works only if you use when as an expression (using the result) and not as a statement:
 * */

class Text1{
    fun log(e: Error) = when(e) {
        is FileReadError -> { println("Error while reading file ${e}") }
        is DatabaseError -> { println("Error while reading from database ${e}") }
        is RuntimeError ->  { println("Runtime error") }
        // the `else` clause is not required because all the cases are covered
    }
}
/**
 * NOTE::
 * when expressions on 'expect' sealed classes in the common code of multiplatform projects still require an else branch.
 * This happens because subclasses of 'actual' platform implementations aren't known in the common code.
 * */

/*------------------------------------------------end----------------------------------------------------------------------------*/

/** Data Class
 * These are data holding classes.
 * In kotlin this is known as data class
 *
 * compiler automatically derives the following menbers from all properties declared in the primary
 * constructor
 * ** equals/ hashcode pair
 * ** toString() of the form "Person(name = Rishabh, age=42)'
 * ** compomentN() functions corresponding to the properties in their order of declaration
 * ** copy() function
 * */
data class Person(val name: String. val age : Int)

/**
 * To ensure consistancy and meaningful behavior of the generation code, 
 *  data class has to fullfill the following requirements
 *  ** The primary constructor need have atleast one param
 *  ** All primary constructor param need to be marked as val or var
 *  ** Data class cannot be abstract, open sealed or inner
 *
 *  General data class follow these rules
 *
 * *** If there are explicit implementations of equals(), hashCode(), or toString() in the data class body or final implementations in a superclass,
 *     then these functions are not generated, and the existing implementations are used.
 *
 * *** If a supertype has componentN() functions that are open and return compatible types,
 *     the corresponding functions are generated for the data class and override those of the supertype.
 *     If the functions of the supertype cannot be overridden due to incompatible signatures or due to their being final, an error is reported.
 *
 * *** Providing explicit implementations for the componentN() and copy() functions is not allowed.
 *
 * Data Classes may extend other classes.
 * */

/**NOTE
 * On the JVM, if the generated class needs to have a parameterless constructor, default values for the properties have to be specified (see Constructors).
 * */
data class User(val name: String = "", val age: Int = 0)

// Copying
/**
Use the copy() function to copy an object,
allowing you to alter some of its properties while keeping the rest unchanged.
The implementation of this function for the User class above would be as follows:
*/
data class User2(val name: String = "", val age: Int = 0){
    fun copy(name: String= this.name, age: Int= this.age) = User(name, age)
}
/*
* Data classes and destructuring declarations
*
* Component functions generated for data classes make it possible to use them in destructuring declarations:
* */

