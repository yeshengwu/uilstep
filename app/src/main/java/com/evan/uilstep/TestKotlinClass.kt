package com.evan.uilstep

/**
 *  https://developer.android.com/codelabs/kotlin-bootcamp-classes/
 * Kotlin Bootcamp for Programmers 4: Object-oriented programming
 */
class TestKotlinClass(var length: Int = 100, var width: Int = 20, var height: Int = 40) {

    //    var width: Int = 20
//    var height: Int = 40
//    var length: Int = 100

    // Dimensions in cm
//    var length: Int = length
//    var width: Int = width
//    var height: Int = height

    var volume: Int
        get() = width * height * length / 1000
        private set(value) {
            height = (value * 1000) / (width * length)
        }

    constructor(numberOfFish: Int) : this() {
        // this()
        // Note: Every secondary constructor must call the primary constructor first,
        // either directly using this(), or indirectly by calling another secondary constructor.
        // This means that any init blocks in the primary will be called for all constructors,
        // and all the code in the primary constructor will be executed first.

        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1

        // calculate the height needed
        height = (tank / (length * width)).toInt()
        println("aquarium constructor. height = $height")
    }

    init {
        println("aquarium initializing")
    }

    init {
        // 1 liter = 1000 cm^3
        println("Volume: ${width * length * height / 1000} l")
    }

    fun printSize() {
        println(
            "Width: $width cm " +
                    "Length: $length cm " +
                    "Height: $height cm "
        )
    }
}