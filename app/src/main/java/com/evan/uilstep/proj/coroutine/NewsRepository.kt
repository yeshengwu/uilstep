//package com.evan.uilstep.proj.coroutine
//
///**
// * 协程最佳实践
// * https://developer.android.google.cn/kotlin/coroutines/coroutines-best-practices?hl=zh-cn
// */
//class NewsRepository(private val ioDispatcher: CoroutineDispatcher) {
//
//    // As this operation is manually retrieving the news from the server
//    // using a blocking HttpURLConnection, it needs to move the execution
//    // to an IO dispatcher to make it main-safe
//    suspend fun fetchLatestNews(): List<Article> {
//        withContext(ioDispatcher) { /* ... implementation ... */ }
//    }
//}
//
//// This use case fetches the latest news and the associated author.
//class GetLatestNewsWithAuthorsUseCase(
//    private val newsRepository: NewsRepository,
//    private val authorsRepository: AuthorsRepository
//) {
//    // This method doesn't need to worry about moving the execution of the
//    // coroutine to a different thread as newsRepository is main-safe.
//    // The work done in the coroutine is lightweight as it only creates
//    // a list and add elements to it
//    suspend operator fun invoke(): List<ArticleWithAuthor> {
//        val news = newsRepository.fetchLatestNews()
//
//        val response: List<ArticleWithAuthor> = mutableEmptyList()
//        for (article in news) {
//            val author = authorsRepository.getAuthor(article.author)
//            response.add(ArticleWithAuthor(article, author))
//        }
//        return Result.Success(response)
//    }
//}