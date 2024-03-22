
package com.example.errorhandling.tVApp.app.src.main.java.com.example.android.raytv.api.tools.fetchers

import java.net.HttpURLConnection
import java.net.URL

/** Fetches the TV Show for a given query */
object TvShowFetcher {
  fun fetch(query: String): String {
    val encodedUrl = java.net.URLEncoder.encode(query, "utf-8")
    val localUrl = URL("https://api.tvmaze.com/search/shows?q=$encodedUrl")
    with(localUrl.openConnection() as HttpURLConnection) {
      requestMethod = "GET"
      val reader = inputStream.bufferedReader()
      return reader.lines().toArray().asSequence()
        .fold(StringBuilder()) { builder, line ->
          builder.append(line)
        }.toString()
    }
  }

  fun fetchById(showId: Int): String {
    val localUrl = URL("https://api.tvmaze.com/shows/$showId")
    with(localUrl.openConnection() as HttpURLConnection) {
      requestMethod = "GET"
      val reader = inputStream.bufferedReader()
      return reader.lines().toArray().asSequence()
        .fold(StringBuilder()) { builder, line ->
          builder.append(line)
        }.toString()
    }
  }
}