package com.evan.uilstep.playorg.function

class FuncTest {

}

// Taking Functions as Parameters 同样java实现： FunctionsA 这个类 operation 不就是一个接口嘛，傻逼 kotlin
// 应用场景： operation 是函数名称 ，参见 see 下面  map 函数定义的解释
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {  // 1
    return operation(x, y)                                          // 2
}

// Returning Functions
// 应用场景： ??? 这个跟c语言 函数指针很像，工作中有用到的具体例子吗？TODO
fun sum(x: Int, y: Int) = x + y


fun operation(): (Int) -> Int {                                     // 1
    return ::square
}

fun square(x: Int) = x * x

// https://play.kotlinlang.org/byExample/04_functional/02_Lambdas
//  链接 有 lambda 总结的5种写法，只写一种就行了。fuck。


// https://play.kotlinlang.org/byExample/04_functional/03_extensionFunctions
// Extension Functions and Properties TODO 这个还有点用
data class Item(val name: String, val price: Float)

data class Order(val items: Collection<Item>)

fun Order.maxPricedItemValue(): Float = this.items.maxBy { it.price }?.price ?: 0F
fun Order.maxPricedItemName() = this.items.maxBy { it.price }?.name ?: "NO_PRODUCTS"

val Order.commaDelimitedItemNames: String
    get() = items.map {
        println("IN map it = $it") // IN map it = Item(name=Bread, price=25.0) 个人习惯：多debug 看看 类似 it 到底是啥，map 函数
        it.name
    }.joinToString()

// TODO 看下 map 函数定义，到底啥意思啊这个定义  <T, R>
//  evan 解释： T 就是 collection item T。 R 就是 返回 list 的  item 类型
//  transform 就是 函数名，表示 一个转换函数
//  所以这个 map 函数就是 将 一个 collection 中 每个 item 使用 transform 函数，这个 transform
//  返回 R。 最后构造一个 list<R>，并将 transform R 加入list并返回 list<R>。
//
// /**
// * Returns a list containing the results of applying the given [transform] function
// * to each element in the original collection.
// *
// * @sample samples.collections.Collections.Transformations.map
// */
//public inline fun <T, R> Iterable<T>.map(transform: (T) -> R): List<R> {
//    return mapTo(ArrayList<R>(collectionSizeOrDefault(10)), transform)
//}


fun printNonNull(str: String?) {
    println("Printing \"$str\":")

    str?.let {                         // 4
        print("\t")
        it.length
        println()
    }
}

// https://play.kotlinlang.org/byExample/06_scope_functions/02_run
fun getNullableLength(ns: String?) {
    println("for \"$ns\":")
    ns?.run {                                                  // 1
        println("\tis empty? " + isEmpty())                    // 2
        println("\tlength = $length")
        length                                                 // 3
    }
}

class Configuration(var host: String, var port: Int)

// apply returns the object itself。 This function is handy for initializing objects

fun main() {
    val sumResult = calculate(4, 5, ::sum)                          // 4
    val mulResult = calculate(4, 5) { a, b -> a * b }               // 5
    println("sumResult $sumResult, mulResult $mulResult") // sumResult 9, mulResult 20
    // 同样java实现： FunctionsA 这个类

    val func = operation()                                          // 3

    val square = square(2)
    println("square = $square")
    println(func(2))

    println("03_extensionFunctions")
    val order = Order(listOf(Item("Bread", 25.0F), Item("Wine", 29.0F), Item("Water", 12.0F)))

    println("Max priced item name: ${order.maxPricedItemName()}")                           // 4
    println("Max priced item value: ${order.maxPricedItemValue()}")
    println("Items: ${order.commaDelimitedItemNames}")                                      // 5

    println("with") // concisely 简洁： evan 不太需要这个特性
    val configuration = Configuration(host = "127.0.0.1", port = 9000)
    with(configuration) {
        println("$host:$port") // omit the instance name when referring to its members
    }

    // instead of: evan : old
//    println("${configuration.host}:${configuration.port}")
}