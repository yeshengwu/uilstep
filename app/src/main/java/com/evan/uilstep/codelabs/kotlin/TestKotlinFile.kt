package com.evan.uilstep.codelabs.kotlin

import com.evan.uilstep.codelabs.kotlin.SeaLion as SeaLion

/**
 * 1,build aquarium
 * 2,make fish
 */
fun main() {
    buildAquarium();
    makeFish()

    // 菜鸟教程查漏补缺知识点 https://www.runoob.com/kotlin/kotlin-interface.html
    // TODO kotlin 集合类
    // TODO kotlin 多线程
    // TODO kotlin 网络库
    // TODO kotlin 特有的一些语法特性 see ExampleUnitTest.kt

}

fun makeFish() {
    println("---------------------")
    val shark = Shark();
    val pleco = Plecostomus();
    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()

    println("shark is FishAction: ${shark is FishAction}")

    val plecoWithArgColor = Plecostomus(object : FishColor {
        override val color: String
            get() = "fuck black"
    })
    println("plecoWithArgColor: ${plecoWithArgColor.color}")
    plecoWithArgColor.eat()


    
}

fun buildAquarium() {
//    val myAquarium = TestKotlinClass()
//    myAquarium.printSize()
//    myAquarium.height = 60;
//    myAquarium.printSize()

    val aquarium1 = TestKotlinClass()
    aquarium1.printSize()
    // default height and length
    val aquarium2 = TestKotlinClass(width = 25)
    aquarium2.printSize()
    // default width
    val aquarium3 = TestKotlinClass(height = 35, length = 110)
    aquarium3.printSize()
    // everything custom
    val aquarium4 = TestKotlinClass(width = 25, height = 35, length = 110)
    aquarium4.printSize()

    val aquarium6 = TestKotlinClass(numberOfFish = 29)
    aquarium6.printSize()
    println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} l")
    // Notice that the volume is printed twice, once by the init block in the primary constructor before the secondary constructor is executed,
    // and once by the code in buildAquarium().
    // see log below:
    // aquarium initializing
    //Volume: 80 l
    //aquarium constructor. height = 31
    //Width: 20 cm Length: 100 cm Height: 31 cm
    //Volume: 62 l

    val aquarium7 = Aquarium(length = 25, width = 25, height = 40)
    aquarium7.printSize()

    val myAquarium = Aquarium(width = 25, length = 25, height = 40)
    myAquarium.printSize()
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()
    myAquarium() // 约定 调用该类的 默认的 invoke 方法。

}


fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

// In Kotlin, if can also be used as an expression.
fun maxOf2(a: Int, b: Int) = if (a > b) a else b

//fun foo() {
//
//}
//
//fun bar(foo){
//
//}

fun describe(obj: Any): String =
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
    }



