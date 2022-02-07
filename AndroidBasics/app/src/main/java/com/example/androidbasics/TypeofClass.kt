package com.example.androidbasics

fun main(){}

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