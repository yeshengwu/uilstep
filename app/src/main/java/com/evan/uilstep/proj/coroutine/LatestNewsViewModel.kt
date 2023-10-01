//package com.evan.uilstep.proj.coroutine
//
//import androidx.lifecycle.ViewModel
//
//// DO create coroutines in the ViewModel
//class LatestNewsViewModel(
//    private val getLatestNewsWithAuthors: GetLatestNewsWithAuthorsUseCase
//) : ViewModel() {
//
//    private val _uiState = MutableStateFlow<LatestNewsUiState>(LatestNewsUiState.Loading)
//    val uiState: StateFlow<LatestNewsUiState> = _uiState
//
//    fun loadNews() {
//        viewModelScope.launch {
//            val latestNewsWithAuthors = getLatestNewsWithAuthors()
//            _uiState.value = LatestNewsUiState.Success(latestNewsWithAuthors)
//        }
//    }
//}
//
//// Prefer observable state rather than suspend functions from the ViewModel
////class LatestNewsViewModel(
////    private val getLatestNewsWithAuthors: GetLatestNewsWithAuthorsUseCase
////) : ViewModel() {
////    // DO NOT do this. News would probably need to be refreshed as well.
////    // Instead of exposing a single value with a suspend function, news should
////    // be exposed using a stream of data as in the code snippet above.
////    suspend fun loadNews() = getLatestNewsWithAuthors()
////}