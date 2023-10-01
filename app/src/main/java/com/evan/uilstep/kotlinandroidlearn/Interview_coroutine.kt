package com.evan.uilstep.kotlinandroidlearn

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.AbstractFlow

/**
 * [for Interview]
 * https://kotlinlang.org/
 */

//fun main() = runBlocking<Unit> {
//    val job = launch {
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello,")
//    job.join()
//}

//suspend fun main() {                                // A function that can be suspended and resumed later
//    val start = System.currentTimeMillis()
//    coroutineScope {                                // Create a scope for starting coroutines
//        for (i in 1..10) {
//            launch {                                // Start 10 concurrent tasks
////                delay(3000L - i * 300)              // Pause their execution
//                delay(10L)
//                log(start, "Countdown: $i")
//            }
//        }
//    }
//    // Execution continues when all coroutines in the scope have finished
//    log(start, "Liftoff!")
//}

suspend fun main() {

//    val coroutineScope = CoroutineScope(Dispatchers.Main)
//    coroutineScope.launch {
//        val message = getNetMessages()
//        showMessage(message)
//    }

//    val coroutineScope = CoroutineScope(Dispatchers.Default)
//    coroutineScope.launch {
//        println("delay before")
//        delay(100)
//        println("delay after")
//    }

//    val job = launch {
//        delay(100)
//    }
    val job = GlobalScope.launch {
        println("delay before")
        delay(1000)
        println("delay after")
    }

    println("end ")

}


suspend fun getNetMessages(): String {
    println("getNetMessages")
    return withContext(Dispatchers.IO) {
        println("getNetMessages io")
        delay(1000)
        println("getNetMessages io2")
        "123"
    }
}

fun showMessage(msg: String) {
    println("showMessage : $msg")
}

fun log(start: Long, msg: String) {
    println(
        "$msg " +
                "(on ${Thread.currentThread().name}) " +
                "after ${(System.currentTimeMillis() - start) / 1000F}s"
    )
}
