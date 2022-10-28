package com.rustyrobot.donow.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.rustyrobot.donow.data.models.ToDoTask
import com.rustyrobot.donow.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        },
        content = {}
    )
}