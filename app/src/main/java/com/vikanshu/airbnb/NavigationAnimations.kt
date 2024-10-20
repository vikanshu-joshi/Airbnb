package com.vikanshu.airbnb

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically

object NavigationAnimations {

    val ENTER_SLIDE_IN_RIGHT = slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(500))

    val ENTER_SLIDE_IN_LEFT = slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(500))

    val EXIT_SLIDE_OUT_RIGHT = slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(500))

    val EXIT_SLIDE_OUT_LEFT = slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(500))

    val ENTER_SLIDE_IN_BOTTOM = slideInVertically(initialOffsetY = { it }, animationSpec = tween(500))

    val EXIT_SLIDE_OUT_BOTTOM = slideOutVertically(targetOffsetY = { it }, animationSpec = tween(500))

    val EXIT_FADE_OUT = fadeOut(tween(500))

    val ENTER_FADE_IN = fadeIn(tween(500))
}