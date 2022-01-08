package com.example.androidbasics

fun main() {}
class BackingProperty {
    var size = 0;

    /**
     *Backing fields & Backing properties
     *
    In Kotlin, a field is only used as a part of a property to hold its value in memory. Fields cannot be declared directly.
    However, when a property needs a backing field, Kotlin provides it automatically.
    This backing field can be referenced in the accessors using the field identifier:

     * The field identifier can only be used in the accessors of the property.
     **/
    var counter = 0 // the initializer assigns the backing field directly
        set(value) {
            if (value >= 0)
                field = value
            // counter = value // ERROR StackOverflow: Using actual name 'counter' would make setter recursive
        }

    /*
A backing field will be generated for a property if it uses the default implementation of at least one of the accessors,
 or if a custom accessor references it through the field identifier.
* For example, there would be no backing field in the following case:
*/
    val isEmpty: Boolean
        get() = this.size == 0
}

/*
If you want to do something that does not fit into this implicit backing field scheme, you can always fall back to having a backing property:
* */
private var _table: Map<String, Int>? = null
public val table: Map<String, Int>
    get() {
        if (_table == null) {
            _table = HashMap() // Type parameters are inferred
        }
        return _table ?: throw AssertionError("Set to null by another thread")
    }
//Note : On the JVM: Access to private properties with default getters and setters is optimized to avoid function call overhead.


/**
 * Late-initialized properties and variables
 *  lateinit modifier : this modifier is used on var properties declared inside the body of class
 *  (not in the primary constructor, and only when the property does not have custom getter ans setter)
 * as well as for top-level properties and local variable.

 ***Note ***: The type of the property or variable must be non-null, and it must not be a primitive type.
 * */
public class TestSubject {}
public class MyTest {
    //    Normally, properties declared as having a non-null type must be initialized in the constructor.
//    However, it is often the case that doing so is not convenient. For example,
//    properties can be initialized through dependency injection, or in the setup method of a unit test. In these cases,
//    you cannot supply a non-null initializer in the constructor,
//    but you still want to avoid null checks when referencing the property inside the body of a class.
    lateinit var testSubject: TestSubject

    //    setup will call after constructor call
    fun setup() {
        testSubject = TestSubject()
    }

    fun test() {
//    To check whether a lateinit var has already been initialized, use .isInitialized on the reference to that property:
        if (::testSubject.isInitialized) {
//            Note :->This check is only available for properties that are lexically accessible when declared in the same type,
        //            in one of the outer types, or at top level in the same file.
        }
    }
}