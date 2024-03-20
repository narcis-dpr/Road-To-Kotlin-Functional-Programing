
package com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.ui.screens.detail

import android.widget.TextView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.raywenderlich.android.raytv.R
import com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.model.ShowDetail

@ExperimentalAnimationApi
@Composable
fun TvShowDetail(
  modifier: Modifier = Modifier,
  detailViewModel: DetailViewModel = hiltViewModel(),
  showId: Int
) {
  LaunchedEffect(true) {
    detailViewModel.findShowDetail(showId)
  }
  val currentState = detailViewModel.showDetailState.value
  val currentTitle: String
  when (currentState) {
    SearchDetailRunning -> {
      currentTitle = "Loading"
    }
    is SuccessDetailResult -> {
      currentTitle = currentState.data.name
    }
    is FailureDetailResult -> {
      currentTitle = "Error"
    }
  }
  Scaffold(
    topBar = { TopAppBar(title = { Text(currentTitle) }) },
    content = {
      val result = detailViewModel.showDetailState.value
      when (result) {
        is SuccessDetailResult -> {
          ShowDetail(showDetail = result.data)
        }
        else -> {

        }
      }
    },
  )
}

@ExperimentalAnimationApi
@Composable
fun ShowDetail(modifier: Modifier = Modifier, showDetail: ShowDetail) {
  Column(modifier.padding(16.dp)) {
    Row {
      Image(
        painter = rememberImagePainter(
          data = showDetail.image?.original ?: R.mipmap.ic_launcher,
          builder = {
            placeholder(R.mipmap.ic_launcher)
          }
        ),
        contentDescription = "TV Show Poster",
        modifier = Modifier
          .size(200.dp)
          .padding(2.dp),
      )
      Column {
        AnimatedVisibility(visible = !showDetail.type.isNullOrEmpty()) {
          Text("${stringResource(id = R.string.genre_label)}: ${showDetail.genres.joinToString()}")
        }
        AnimatedVisibility(visible = !showDetail.language.isNullOrEmpty()) {
          Text("${stringResource(id = R.string.language_label)}: ${showDetail.language}")
        }
        AnimatedVisibility(visible = !showDetail.premiered.isNullOrEmpty()) {
          Text("${stringResource(id = R.string.premiered_label)}: ${showDetail.premiered}")
        }
        AnimatedVisibility(visible = !showDetail.ended.isNullOrEmpty()) {
          Text("${stringResource(id = R.string.ended_label)}: ${showDetail.ended}")
        }
      }
    }
    AnimatedVisibility(visible = !showDetail.summary.isNullOrEmpty()) {
      Column(modifier = modifier) {
        Text(
          modifier = modifier,
          fontWeight = FontWeight.Bold,
          fontSize = 20.sp,
          text = stringResource(id = R.string.summary_label)
        )
        Html(showDetail.summary ?: "")
      }
    }
  }
}

@Composable
fun Html(text: String) {
  AndroidView(factory = { context ->
    TextView(context).apply {
      setText(HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY))
    }
  })
}