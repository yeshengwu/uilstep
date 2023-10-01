package com.evan.uilstep.kotlinandroidlearn

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.AbstractFlow
import org.json.JSONObject

/**
 * [for Interview]
 * https://kotlinlang.org/
 */

fun main() {
    println("before loadVideoSourceAndPlay  called${Thread.currentThread()}")
    loadVideoSourceAndPlay("filename")
    println("after loadVideoSourceAndPlay  called${Thread.currentThread()}")
}

private fun loadVideoSourceAndPlay(videoFileName: String) {
    println("before launch io called${Thread.currentThread()}")
    val coroutineScope = CoroutineScope(Dispatchers.IO)
    coroutineScope.launch {
        println("IN launch io called${Thread.currentThread()}")
        val jsonObject = JSONObject("{\"name\":\"BeJson\"}")
        val name = jsonObject.optString("name")
        println("name = $name, parma = $videoFileName")
    }

    println("after launch io called${Thread.currentThread()}")
}