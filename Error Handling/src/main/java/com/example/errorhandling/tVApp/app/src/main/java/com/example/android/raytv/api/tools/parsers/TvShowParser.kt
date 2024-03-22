
package com.example.errorhandling.tVApp.app.src.main.java.com.example.android.raytv.api.tools.parsers

import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.raytv.model.ScoredShow
import kotlinx.serialization.KSerializer
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
}

private fun ScoredShow.Companion.serializer(): KSerializer<ScoredShow> {
  TODO("Not yet implemented")
}
