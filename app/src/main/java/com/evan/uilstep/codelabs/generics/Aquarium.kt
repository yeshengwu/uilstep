package com.evan.uilstep.codelabs.generics

/**
 * https://developer.android.com/codelabs/kotlin-bootcamp-generics
 */

// To not allow passing null, make T of type Any explicitly, by removing the ? after Any.
// class Aquarium<T: Any?>(val waterSupply: T)
// Add more checking
class Aquarium<out T : WaterSupply>(val waterSupply: T) {
    //class Aquarium<T: Any>(val waterSupply: T) {
    fun addWater() {
        check(!waterSupply.needsProcessing) { "water supply needs processing first" }
        println("adding water from $waterSupply")
    }

    //    fun <R: WaterSupply> hasWaterSupplyOfType() = waterSupply is R
    // 上面报错后 idea 提示改为如下即可：reified inline  Kotlin needs to know about them at runtime, not just compile time
    // like is checks on generic types That's why Kotlin added reified, or real, types.
    inline fun <reified R : WaterSupply> hasWaterSupplyOfType() = waterSupply is R
    // If you don't use reified here, the type won't be "real" enough for Kotlin to allow is checks.
    // That's because non-reified types are only available at compile time, and can't be used at runtime by your program.
    // This is discussed more in the next section.
}

/**
 * Aquarium extensions 扩展函数，如果 Aquarium 类本身有这个方法，则优先用内部的。
 */
inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R

/**
 * todo 留一个问题： 一个类能同时声明 in out 吗，比如这个 Cleaner？
 */
interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}


fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

//fun isWaterClean(aquarium: Aquarium<WaterSupply>) {
//    println("aquarium water is clean: ${!aquarium.waterSupply.needsProcessing}")
//}

fun <T : WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${!aquarium.waterSupply.needsProcessing}")
}

fun genericsExample() {
    val aquarium = Aquarium<TapWater>(TapWater())

    //  out 反编译jax里长啥样,跟没加是一样的
    // todo 教程引用到的 kotlin 官方，还是有点复杂的，需要结合理解java 范型 https://kotlinlang.org/docs/generics.html#underscore-operator-for-type-arguments
    //  教程提醒 不懂没太大关系，鼠标点击 范型参数 出现黄色小球 按他提示(Add 'in' variance)来加即可。
    // 如果 Aquarium 类 T 没用 out 修饰，则报 Type mismatch.
    //Required:
    //Aquarium<WaterSupply>
    //Found:
    //Aquarium<TapWater>
    addItemTo(aquarium)

    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
    aquarium.waterSupply.addChemicalCleaners()
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")

    val aquarium4 = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
    aquarium4.addWater()

    isWaterClean<TapWater>(aquarium)

    println(aquarium.hasWaterSupplyOfType<TapWater>())   // true
    println(aquarium.waterSupply.isOfType<TapWater>())
}

fun main() {
    genericsExample()
}

/**
 * evan: 水源： TapWater：自来水  LakeWater：湖水   FishStoreWater：卖鱼店的水
 */
open class WaterSupply(var needsProcessing: Boolean)

/**
 *  WaterSupply extension 扩展函数
 */
inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessing = false
    }
}


class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessing = false
    }
}