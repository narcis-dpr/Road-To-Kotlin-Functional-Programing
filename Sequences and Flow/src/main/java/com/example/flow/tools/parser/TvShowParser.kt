package com.example.flow.tools.parser

import com.example.flow.model.ScoredShow
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

/** Parser for the JSON */
object TvShowParser {

  private val jsonConfig = Json {
    ignoreUnknownKeys = true
  }

  /** Parses the json in input */
//  fun parse(json: String): List<ScoredShow> =
//    jsonConfig.decodeFromString<List<ScoredShow>>(ListSerializer(ScoredShow.serializer()), json)
}