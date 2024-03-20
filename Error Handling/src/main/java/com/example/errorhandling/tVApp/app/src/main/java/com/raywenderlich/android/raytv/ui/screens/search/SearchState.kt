
package com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.ui.screens.search

import com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.model.ScoredShow

/** Sealed class for the result of the search */
sealed class SearchState
object NoSearchDone : SearchState()
object SearchRunning : SearchState()
data class SuccessSearchResult(val data: List<ScoredShow>) : SearchState()
object NoSearchResult : SearchState()
data class FailureSearchResult(val error: Throwable) : SearchState()