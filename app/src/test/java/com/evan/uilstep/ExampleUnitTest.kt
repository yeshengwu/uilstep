package com.evan.uilstep

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)


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


        // 匿名函数
        val stringLengthFunc: (String) -> Int = { input ->
            input.length
        }
        val stringLength: Int = stringLengthFunc("Android")
        println("Android stringLength invoke func $stringLength")
    }

    fun generateAnswerString(countThreshold: Int): String {
        val answerString = if (countThreshold == 42) {
            "I have the answer."
        } else {
            "The answer eludes me"
        }
        return answerString;
    }

    fun stringMapper(str: String, mapper: (String) -> Int): Int {
        // invoke function
        return mapper(str)
    }

//    private void strJavaMapper (){
//
//    }


}