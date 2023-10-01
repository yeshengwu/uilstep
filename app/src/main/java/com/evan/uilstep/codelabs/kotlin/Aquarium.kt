package com.evan.uilstep.codelabs.kotlin

import java.lang.Math.PI
/**
 * course overview:
 * https://developer.android.com/codelabs/kotlin-bootcamp-welcome#1
 */
open class Aquarium(open var length: Int = 100, var width: Int = 20, open var height: Int = 40) {

    init {
        println("aquarium initializing")
    }

    init {
        // 1 liter = 1000 cm^3
        println("Volume: ${width * length * height / 1000} l")
    }

    // 通过反编译成java代码看 init 语句块 在 class 文件中放哪里，才能知道 调用顺序。
    // 可以这里打开这个 kt 生成的 class文件： build/tmp/kotlin-classes/debug/com/evan/uilstep/Aquarium.class
    // 打开这个 class文件后 ， as menu 上 Tools->kotlin->Decompile To Java 查看 class 字节码反编译成 java代码
    // 得知结果： init 语句块 在 构造器中，已经可以 读取到 属性 值了。且 多个 init 语句块 则按顺序放入 构造器方法最后几行。

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open val shape = "rectangle"

    open var water: Double = 0.0
        get() = volume * 0.9

    fun printSize() {
        println(shape)
        println(
            "Width: $width cm " +
                    "Length: $length cm " +
                    "Height: $height cm "
        )
        // 1 l = 1000 cm^3
        println("Volume: $volume l Water: $water l (${water / volume * 100.0}% full)")
    }

    operator fun invoke():String {
        val result = "evan"
        println("IN invoke, $this was invoke() and return value: $result")
        return result
    }

    // fixme: TowerTank 写在这？ 如果写在这，外部调用 则为 Aquarium.TowerTank 不妥，不是内部类现在是 子类
//     class TowerTank (override var height: Int, var diameter: Int)
//         : Aquarium(height = height, width = diameter, length = diameter) {
//
//     }
}

// fixme: TowerTank 写在这？是的
// 参考： 圆柱体水缸。  Int 所在的 Primitives.kt 中  Int Byte Long 这些类是同级关系，不写在其他兄弟内部
class TowerTank(override var height: Int, var diameter: Int) :
    Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
        // ellipse area = π * r1 * r2
        get() = (width / 2 * length / 2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width / 2 * length / 2)).toInt()
        }

    override var water = volume * 0.8
    override val shape = "cylinder"
}




