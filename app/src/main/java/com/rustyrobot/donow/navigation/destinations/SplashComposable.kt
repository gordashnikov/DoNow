package com.rustyrobot.donow.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.rustyrobot.donow.ui.screens.splash.SplashScreen
import com.rustyrobot.donow.util.Constants.SPLASH_SCREEN

@ExperimentalAnimationApi
@ExperimentalMaterialApi
fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit
) {
    composable(
        route = SPLASH_SCREEN,
        exitTransition = {
            slideOutVertically(
                animationSpec = tween(durationMillis = 700),
                targetOffsetY = { -it }
            )
        }
    ) {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}