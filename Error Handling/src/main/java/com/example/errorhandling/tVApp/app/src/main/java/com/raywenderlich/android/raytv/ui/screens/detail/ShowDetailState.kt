
package com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.ui.screens.detail

import com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.model.ShowDetail

/** Sealed class for the result of the detail */
sealed class ShowDetailState
object SearchDetailRunning : ShowDetailState()
data class SuccessDetailResult(val data: ShowDetail) : ShowDetailState()
data class FailureDetailResult(val error: Throwable) : ShowDetailState()