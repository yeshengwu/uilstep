//package com.evan.uilstep.proj.coroutine
//
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//import java.io.InputStream
//import java.net.HttpURLConnection
//import java.net.URL
//
//sealed class Result<out R> {
//    data class Success<out T>(val data: T) : Result<T>()
//    data class Error(val exception: Exception) : Result<Nothing>()
//}
//
//class LoginRepository(private val responseParser: LoginResponseParser) {
//    private val loginUrl = "https://example.com/login"
//
//    // Function that makes the network request, blocking the current thread
////    fun makeLoginRequest(
////        jsonBody: String
////    ): Result<LoginResponse> {
////        val url = URL(loginUrl)
////        (url.openConnection() as? HttpURLConnection)?.run {
////            requestMethod = "POST"
////            setRequestProperty("Content-Type", "application/json; utf-8")
////            setRequestProperty("Accept", "application/json")
////            doOutput = true
////            outputStream.write(jsonBody.toByteArray())
////            return Result.Success(responseParser.parse(inputStream))
////        }
////        return Result.Error(Exception("Cannot open HttpURLConnection"))
////    }
//
//    suspend fun makeLoginRequest(
//        jsonBody: String
//    ): Result<LoginResponse> {
//        // Move the execution of the coroutine to the I/O dispatcher
//        return withContext(Dispatchers.IO) {
//
//            val url = URL(loginUrl)
//            (url.openConnection() as? HttpURLConnection)?.run {
//                requestMethod = "POST"
//                setRequestProperty("Content-Type", "application/json; utf-8")
//                setRequestProperty("Accept", "application/json")
//                doOutput = true
//                outputStream.write(jsonBody.toByteArray())
//                Result.Success(responseParser.parse(inputStream))
//            }
//            Result.Error(Exception("Cannot open HttpURLConnection"))
//        }
//
//    }
//}
//
//class LoginResponse {
//
//}
//
//class LoginResponseParser {
//    fun parse(inputStream: InputStream?): LoginResponse {
//        TODO("Not yet implemented")
//    }
//
//}
