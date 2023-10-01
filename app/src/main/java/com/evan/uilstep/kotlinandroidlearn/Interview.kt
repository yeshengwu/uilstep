package com.evan.uilstep.kotlinandroidlearn

/**
 * [for Interview]
 */
fun main() {
    testNull("evan", null)
//    testNull(null, null) // name要求非空，这里传空会编译报错不过
//    AbstractFlow
    measureTimeMillis {
        // 调用该函数时，函数体内容被插入到这里
        Thread.sleep(1000)
    }
}

/**
 * 内联函数优缺点
 */
inline fun measureTimeMillis(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    val end = System.currentTimeMillis() - start
    println("Time taken: $end ms")
}

/**
 * name：这里要求非空，sex，可空 as 右上角 kotlin Bytecode 实时可以看反编译代码更清晰。
 */
fun testNull(name: String, sex: String?) {
    println("name=$name, and sex = $sex")
}