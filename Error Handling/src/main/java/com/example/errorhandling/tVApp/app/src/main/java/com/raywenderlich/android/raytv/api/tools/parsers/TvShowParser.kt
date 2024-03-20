
package com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.api.tools.parsers

import com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.model.ScoredShow
import com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.model.ShowDetail
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

/** Parser for the JSON */
object TvShowParser {

  private val jsonConfig = Json {
    ignoreUnknownKeys = true
  }

  /** Parses the json in input */
  fun parse(json: String): List<ScoredShow> =
    jsonConfig.decodeFromString<List<ScoredShow>>(ListSerializer(ScoredShow.serializer()), json)

  /** Parses the json in input */
  fun parseDetail(json: String): ShowDetail =
    jsonConfig.decodeFromString<ShowDetail>(ShowDetail.serializer(), json)
}