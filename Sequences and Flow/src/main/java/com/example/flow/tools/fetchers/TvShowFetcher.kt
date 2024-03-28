package com.example.flow.tools.fetchers

import java.net.HttpURLConnection
import java.net.URL

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
}