package com.example.flow

import com.example.flow.tools.fetchers.TvShowFetcher
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.withContext
import java.io.IOException
import kotlin.coroutines.CoroutineContext

suspend fun fetchTvShowResult(
    ctx: CoroutineContext,
    query: String
): Result<String> = withContext(ctx) {
    try {
        Result.success(TvShowFetcher.fetch(query))
    } catch (ioe: IOException) {
        Result.failure(ioe)
    }
}

val fetchSuspendResult: (String) -> SuspendableStateResult<CoroutineContext, String> = {query ->
    SuspendableStateResult { ctx: CoroutineContext ->
        ctx to fetchTvShowResult(ctx, query)
    }
}

suspend fun searchTvShow(ctx: CoroutineContext) = withContext(ctx) {
    inputStringFlow("search your show: ")

}