
package com.example.errorhandling.tVApp.app.src.main.java.com.raywenderlich.android.raytv.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@Composable
fun ErrorAlert(
  errorMessage: @Composable () -> String,
  visible: () -> Boolean
) {
  AnimatedVisibility(
    visible = visible(),
    enter = slideInVertically(
      // Enters by sliding down from offset -fullHeight to 0.
      initialOffsetY = { fullHeight -> -fullHeight },
      animationSpec = tween(durationMillis = 150, easing = LinearOutSlowInEasing)
    ),
    exit = slideOutVertically(
      // Exits by sliding up from offset 0 to -fullHeight.
      targetOffsetY = { fullHeight -> -fullHeight },
      animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
    )
  ) {
    Surface(
      modifier = Modifier.fillMaxWidth(),
      color = MaterialTheme.colors.secondary,
      elevation = 4.dp
    ) {
      Text(
        text = errorMessage(),
        modifier = Modifier.padding(16.dp)
      )
    }
  }
}