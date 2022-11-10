package com.evan.uilstep.codelabs.kotlin

/**
 * 9. Task: Create a data class https://developer.android.com/codelabs/kotlin-bootcamp-classes/#8
 */
data class Decoration(val rocks: String, val wood: String, val diver: String) {


}

fun makeDecorations() {
    val decoration1 = Decoration("granite","wood","driver")
    println(decoration1)

    val decoration2 = Decoration("slate","wood","driver")
    println(decoration2)

    val decoration3 = Decoration("slate","wood","driver")
    println(decoration3)

    println (decoration1.equals(decoration2))
    println (decoration3.equals(decoration2))


    println ("destructuring======")
    // destructuring
    val d5 = Decoration("crystal", "wood", "diver")
    println(d5)
    println ("destructuring end 1======")

    val (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)
    println ("destructuring end 2======")

    val (rock2, _, diver2) = d5
    println(rock2)
    println(diver2)
    println ("destructuring end 3======")
    // destructuring======
    //Decoration(rocks=crystal, wood=wood, diver=diver)
    //destructuring end 1======
    //crystal
    //wood
    //diver
    //destructuring end 2======
    //crystal
    //diver
    //destructuring end 3======

}

enum class Color (val rgb:Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}

fun main(){
    makeDecorations()
    testEnum()
}

fun testEnum() {
    println(Color.RED.name)
    println(Color.RED.ordinal)
    println(Color.RED.rgb)
}
