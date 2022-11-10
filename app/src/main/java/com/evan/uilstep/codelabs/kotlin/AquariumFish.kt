package com.evan.uilstep.codelabs.kotlin

/**
 * https://developer.android.com/codelabs/kotlin-bootcamp-classes/#8
 * 8、Task: Use interface delegation
 */
interface FishAction {
    fun eat()
}

//abstract class AquariumFish {
//    abstract val color: String
//}
//
// // 继承 父类：AquariumFish 实现接口：FishAction
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

//class Plecostomus: FishAction, FishColor {
//    override val color = "gold"
//    override fun eat() {
//        println("eat algae")
//    }
//}

class Shark : FishAction, FishColor {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

// 单例
object GoldColor : FishColor {  // evan: 实现  FishColor 接口
    override val color = "gold"
}

//  interface delegation ： 接口委托/  也就是 接口的实现 代理给 xxx这个类 来实现

// 原本定义
//class Plecostomus:  FishAction, FishColor by GoldColor {
//    override fun eat() {
//        println("eat algae")
//    }
//}

// fishColor 就是构造器中传入的 参数。
// fishColor: FishColor = GoldColor 就是 默认值是 GoldColor
// FishColor by fishColor 意思就是 FishColor 接口的实现 委托给 fishColor。
// 整体串起来就是： Plecostomus 类将 实现 FishColor 接口的任务 委托给 其他人 比如 参数 fishColor.
// 至于为啥委托给 参数 fishColor 因为刚好业务需求： Plecostomus  需要颜色参数。 也可以指定为其他 参数来实现。
class Plecostomus(fishColor: FishColor = GoldColor) : FishAction, FishColor by fishColor {
    override fun eat() {
        println("eat algae")
    }
}

//class Plecostomus(ageColor: FishColor = GoldColor,name:String) : FishAction, FishColor by ageColor {
//    override fun eat() {
//        println("eat algae")
//    }
//}

// 如果没有 by 编译报错：Class 'Plecostomus' is not abstract and does not implement abstract member color in FishColor
//class Plecostomus(fishColor: FishColor = GoldColor) : FishAction, FishColor /*by fishColor*/ {
//    override fun eat() {
//        println("eat algae")
//    }
//}

// A sealed class is a class that can be subclassed, but only inside the file in which it's declared.
// If you try to subclass the class in a different file, you get an error.
sealed class Seal
class SeaLion : Seal()
class Walrus : Seal()
// Walrus： 海象

fun matchSeal(seal: Seal): String {
    return when (seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}
// The Seal class can't be subclassed in another file. If you want to add more Seal types,
// you have to add them in the same file. This makes sealed classes a safe way to represent
// a fixed number of types. For example, sealed classes are great for returning success or error from a network API.