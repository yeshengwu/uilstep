//package com.evan.uilstep.proj.coroutine
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.launch
//
///**
// * ref: android官网入口
// * https://developer.android.google.cn/kotlin/ktx?hl=zh-cn#kts
// *
// */
//class MainViewModel : ViewModel() {
//    // Make a network request without blocking the UI thread
//    private fun makeNetworkRequest() {
//        // launch a coroutine in viewModelScope
//        viewModelScope.launch  {
////            remoteApi.slowFetch()
//        }
//    }
//
//    // No need to override onCleared()
//}