package com.rustyrobot.donow.data.navigation

import androidx.navigation.NavHostController
import com.rustyrobot.donow.util.Action
import com.rustyrobot.donow.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {

    val list: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
}