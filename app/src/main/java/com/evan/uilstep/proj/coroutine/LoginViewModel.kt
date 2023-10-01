//package com.evan.uilstep.proj.coroutine
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
///**
// * https://developer.android.google.cn/kotlin/coroutines?hl=zh-cn Android 上的 Kotlin 协程
// */
//
//class LoginViewModel(
//    private val loginRepository: LoginRepository
//): ViewModel() {
//
////    fun login(username: String, token: String) {
////        // Create a new coroutine to move the execution off the UI thread
////        viewModelScope.launch(Dispatchers.IO) {
////            val jsonBody = "{ username: \"$username\", token: \"$token\"}"
////            loginRepository.makeLoginRequest(jsonBody)
////        }
////    }
//
//    fun login(username: String, token: String) {
//        // Create a new coroutine to move the execution off the UI thread
//        viewModelScope.launch {
//            val jsonBody = "{ username: \"$username\", token: \"$token\"}"
//            // Make the network call and suspend execution until it finishes
//            val result = loginRepository.makeLoginRequest(jsonBody)
//
//            // Display result of the network request to the user
//            when(result) {
//                is com.evan.uilstep.proj.coroutine.Result.
//            }
//        }
//    }
//}