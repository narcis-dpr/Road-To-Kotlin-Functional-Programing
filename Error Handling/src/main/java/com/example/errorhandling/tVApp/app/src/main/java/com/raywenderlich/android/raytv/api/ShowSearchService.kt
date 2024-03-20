package com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.api

import com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.api.tools.fetchers.TvShowFetcher
import com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.api.tools.parsers.TvShowParser
import com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.model.ScoredShow
import com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.model.ShowDetail
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