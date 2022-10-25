package com.rustyrobot.donow.data.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.rustyrobot.donow.util.Action
import com.rustyrobot.donow.util.Constants.TASK_ARGUMENT_KEY
import com.rustyrobot.donow.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(navigateToListScreen: (Action) -> Unit) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) {

    }
}