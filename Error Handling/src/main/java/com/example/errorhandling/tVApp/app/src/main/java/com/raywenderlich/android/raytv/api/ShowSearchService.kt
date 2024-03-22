package com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.api

import com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.api.tools.fetchers.TvShowFetcher
import com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.api.tools.parsers.TvShowParser
import com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.model.ScoredShow
import com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.model.ShowDetail
import com.example.errorhandling.tVApp.libs.fp.src.main.kotlin.com.raywenderlich.fp.lib.Either
import com.example.errorhandling.tVApp.libs.fp.src.main.kotlin.com.raywenderlich.fp.lib.Optional
import com.example.errorhandling.tVApp.libs.fp.src.main.kotlin.com.raywenderlich.fp.lib.flatMap
import com.raywenderlich.fp.result.flatMap
import kotlinx.serialization.SerializationException
import java.io.IOException

/** Invokes the fetcher returning an Result<T> */
fun fetchTvShowResult(query: String): Result<String> = try {
    Result.success(TvShowFetcher.fetch(query))
} catch (ioe: IOException) {
    Result.failure(ioe)
}

/** Invokes the parser returning an Result<T> */
fun parseTvShowResult(json: String): Result<List<ScoredShow>> =
    try {
        Result.success(TvShowParser.parse(json /* +"sabotage" */))
    } catch (e: SerializationException) {
        Result.failure(e)
    }

fun fetchTvShowDetailResult(showId: Int): Result<String> = try {
    Result.success(TvShowFetcher.fetchById(showId))
} catch (ioe: IOException) {
    Result.failure(ioe)
}

fun parseTvShowDetailResult(json: String): Result<ShowDetail> =
    try {
        Result.success(TvShowParser.parseDetail(json))
    } catch (e: SerializationException) {
        Result.failure(e)
    }

/** Composition of fetchTvShowResult and parseTvShowResult */
fun fetchAndParseTvShowResult(query: String) =
    fetchTvShowResult(query)
        .flatMap(::parseTvShowResult)

fun fetchAndParseTvShowDetailResult(showId: Int) =
    fetchTvShowDetailResult(showId)
        .flatMap(::parseTvShowDetailResult)

fun fetchTvShowOptional(query: String): Optional<String> = try {
    Optional.lift(TvShowFetcher.fetch(query))
} catch (ioe: IOException) {
    Optional.empty()
}

fun parseTvShowString(json: String): Optional<List<ScoredShow>> {
    return try {
        Optional.lift(TvShowParser.parse(json))
    } catch (e: Exception) {
        Optional.empty()
    }
}

fun fetchAndParseTvShow(query: String) = fetchTvShowOptional(query).flatMap(::parseTvShowString)

// try with Either :
fun fetchTvShowEither(query: String): Either<IOException, String> = try {
    Either.right(TvShowFetcher.fetch(query))
} catch (ioe: IOException) {
    Either.left(ioe)
}

fun parseTvShowEither(json: String): Either<Exception, List<ScoredShow>> = try {
    Either.right(TvShowParser.parse(json))
} catch (e: Exception) {
    Either.left(e)
}

fun fetchAndParseTvShowEither(query: String) =
    fetchTvShowEither(query)
        .flatMap(::parseTvShowEither)