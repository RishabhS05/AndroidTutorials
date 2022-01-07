package com.example.androidbasics

fun main() {
}

/**Inheritance
 *
 * Classes can be derived form each other and form inheritance hierarchies.
 * All the class by default inherit "Any class",
 *
 * **/

/*
* Abstract Class
* ** A class may be declared abstract, along with some or all of its members
* *** An abstract member does not have an implementation/ body.
* **** you don't need to annotate abstract classes or function with "open"
*  syntax
* */

abstract class Base {
    abstract fun show()
}

class Child : Base() {
    //    abstract methods of abstract class has to override in the child class
    override fun show() {
        TODO("Not yet implemented")
    }
}

/**You can override a non-abstract open member with an abstract one.
 * By Default kotlin classes are final.they can’t be inherited, to make class inheritable, mark it with the open
 * */
//Normal class can not be inherited in kotlin, it is by default final class (in java)
// if we need to inherit a class the parent class must be annotated as 'open'
open class Parent {}


class Son : Parent() {}

open class Polygon {
    open fun draw() {
        // some default polygon drawing method
    }
}

abstract class WildShape : Polygon() {
    // Classes that inherit WildShape need to provide their own
    // draw method instead of using the default on Polygon
    abstract override fun draw()
}

/**
 * Overriding Methods
 * */
open class Shape {
    open fun draw() {

    }

    fun fill() {}
}
// only draw method is allowed to override in kotlin, if we try to override fill method then it cause compiler error


//class Circle: Shape(){
//    override fun fill(){}
//}
//Error : fill is final it cannot be overridden

// correct implementation as follows


class Circle : Shape() {
    override fun draw() {
        super.draw()
    }
//
//    fun fill(): Int{
//        return 0
//    }
//    above cause error :
//    'fill' hides member of supertype 'Shape' and needs 'override' modifier
//    it means that declaring a method with the same signature in a subclass is not allowed, either with override or without it.
}

class NoEffect : Shape() {
    //    'open' modifier no effect when added to member of final class
    open fun size() {
    }
}

open class Rect : Shape() {
    override fun draw() {
        super.draw()
    }
}

class Screen : Rect() {
    //A member marked override is itself open, so it may be overridden in sub classes. if you want to prevent this, mark it final
    // so that its subclasses will not be able to override this method.
    final override fun draw() {
        super.draw()
    }
}