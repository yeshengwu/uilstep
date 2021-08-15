package com.evan.uilstep

/**
 * https://developer.android.com/codelabs/kotlin-bootcamp-classes/#8
 * 8、Task: Use interface delegation
 */
interface FishAction{
    fun eat()
}

//abstract class AquariumFish {
//    abstract val color: String
//}
//
//class Shark : AquariumFish(),FishAction {
//    override val color = "gray"
//    override fun eat() {
//        println("hunt and eat fish")
//    }
//}
//
//class Plecostomus : AquariumFish(),FishAction {
//    override val color = "gold"
//    override fun eat() {
//        println("eat algae")
//    }
//}

interface FishColor {
    val color: String
}

class Shark: FishAction, FishColor {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}


//  interface delegation 意思就是 接口的实现 代理给 xxx这个类来实现接口

// fishColor 意思就是构造器中传入的 参数。 fishColor: FishColor = GoldColor 意思就是 默认值是 GoldColor
// FishColor by fishColor 意思就是 fishColor 的实现委托 给 FishColor 的实现类 xxx。
class Plecostomus(fishColor: FishColor = GoldColor): FishAction, FishColor by fishColor {
    override fun eat() {
        println("eat algae")
    }
}

// 单例
object GoldColor : FishColor {
    override val color = "gold"
}


// A sealed class is a class that can be subclassed, but only inside the file in which it's declared.
// If you try to subclass the class in a different file, you get an error.
sealed class Seal
class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when(seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}