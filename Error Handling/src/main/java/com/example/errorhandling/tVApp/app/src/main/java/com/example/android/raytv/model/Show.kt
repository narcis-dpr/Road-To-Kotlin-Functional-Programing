

package com.example.errorhandling.tVApp.app.src.main.java.com.example.android.raytv.model

import kotlinx.serialization.Serializable

@Serializable
data class ScoredShow(
  val score: Double,
  val show: Show
) {
  companion object
}

@Serializable()
data class Show(
  val id: Int,
  val name: String,
  val genres: List<String>,
  val url: String,
  val image: ShowImage?,
  val summary: String?,
  val language: String?
)

@Serializable()
data class ShowImage(
  val original: String,
  val medium: String
)

@Serializable()
data class ShowDetail(
  val id: Int,
  val url: String,
  val name: String,
  val type: String?,
  val language: String?,
  val genres: List<String>,
  val status: String?,
  val runtime: Int?,
  val averageRuntime: Int?,
  val premiered: String?,
  val ended: String?,
  val officialSite: String?,
  val image: ShowImage?,
  val summary: String?
)