package com.evan.uilstep.playorg

/**
 * https://play.kotlinlang.org/byExample/03_special_classes/04_Object
 */
 class BigBen {
     companion object Bonger {                   //2
        fun getBongs(nTimes: Int) {             //3
            for (i in 1 .. nTimes) {
                print("BONG ")
            }
        }
    }
}


fun main() {
    BigBen.getBongs(12)                         //4

    println("xxxxxxxxxxx")

}