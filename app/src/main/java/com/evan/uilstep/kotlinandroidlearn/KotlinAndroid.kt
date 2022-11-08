package com.evan.uilstep.kotlinandroidlearn

// 匿名函数
val stringLengthFunc: (String) -> Int = { input ->
    input.length
}

val str2IntResult = stringMapper("123") { input ->
    Integer.valueOf(input);
}

// evan： 回调函数不是最后一个参数则不能简写，否则报错编译不过
val str2IntResultNewLast = stringMapperNewParamInLast("123", { input ->
    println("IN mapper input = $input")
    Integer.valueOf(input);
}, "444")

val str2IntResultNewFuncLast = stringMapperNewFuncParamInLast("123", { input ->
    println("IN mapper 1 input = $input")
    Integer.valueOf(input);
}, { input ->
    println("IN mapper 2 input = $input")
    Integer.valueOf(input);
}, "444")

fun main() {
    makeTest()

}

fun makeTest() {
// kotlin 官方学习： https://developer.android.com/kotlin/learn
    var count: Int = 10
    count = 15
//        System.out.println("count = "+count)
//        println("count = "+count)
    println("count = $count")


    val languageName = "Kotlin"
    val upperCaseName = languageName.toUpperCase()
    println("upperCaseName = $upperCaseName")

//        languageName.inc()

    var testInt: Int = 120
    testInt.inc();
    println("testInt after inc but no assign. testInt = $testInt") // testInt = 120

    testInt = testInt.inc();
    println("testInt inc and assign. testInt = $testInt") // testInt inc= 121

    val answerString = when {
        count == 42 -> "I have the answer."
        count > 35 -> "The answer is close."
        else -> "The answer eludes me."
    }

    println(answerString)
    println(generateAnswerString(count))

    val stringLength: Int = stringLengthFunc("Android")
    println("Android stringLength invoke func $stringLength")
    println("---------------")
// 调用方式1
//        val str2IntResult = stringMapper("123", { input ->
//            Integer.valueOf(input);
//        })
// 上面url文档原话：如果匿名函数是在某个函数上定义的最后一个参数，则您可以在用于调用该函数的圆括号之外传递它
// evan： 为什么要用这种？ 调用方式1有什么不好非得搞下面这个？有病吧？为了增加简洁性
// 增加了记忆负担和理解负担，无语了。

    println("str2IntResult = $str2IntResult")
    println("---------------")


    println("str2IntResultNewLast = $str2IntResultNewLast")
    println("---------------")

    println("str2IntResultNewLastLast = $str2IntResultNewFuncLast")
    println("---------------")
}

fun generateAnswerString(countThreshold: Int): String {
    val answerString = if (countThreshold == 42) {
        "I have the answer."
    } else {
        "The answer eludes me"
    }
    return answerString;
}
// 理解为 java 的回调，比如 点击事件回调就更具体清晰
fun stringMapper(str: String, mapper: (String) -> Int): Int {
    println("IN stringMapper param str = $str, cb func = $mapper")
    // invoke function
    // evan 先处理一波 str 参数
//        return mapper(str.plus("345"))
    // origin: 仅仅传递str，不处理参数
    return mapper(str)
}

fun stringMapperNewParamInLast(str: String, mapper: (String) -> Int, newStr: String): Int {
    // invoke function
    return mapper(str.plus(newStr))
}

fun stringMapperNewFuncParamInLast(
    str: String,
    mapper: (String) -> Int,
    mapper2: (String) -> Int,
    newStr: String
): Int {
    // invoke function
    return mapper(str) + mapper2(newStr)
}

//  evan： stringMapper 对应的 java 版本
// private int strJavaMapper(String str, Mapper mapper) {
//        return mapper.mapper(str);
//    }
//
//    interface Mapper {
//        int mapper(String str);
//    }

// int str2IntResult = main.strJavaMapper("123", new Mapper() {
//            @Override
//            public int mapper(String str) {
//                return Integer.valueOf(str);
//            }
//        });
//        System.out.println("str2IntResult = " + str2IntResult);




