package com.evan.uilstep.proj.coroutine

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class KotlinCoroutine1Activity :  AppCompatActivity() {

    companion object {
        const val TAG = "evan_coroutine1Activity"
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        Log.e(TAG,"onCreate")

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

}