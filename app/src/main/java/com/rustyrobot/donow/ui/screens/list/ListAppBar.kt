package com.rustyrobot.donow.ui.screens.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rustyrobot.donow.R
import com.rustyrobot.donow.components.PriorityItem
import com.rustyrobot.donow.data.models.Priority
import com.rustyrobot.donow.ui.theme.LARGE_PADDING
import com.rustyrobot.donow.ui.theme.Typography
import com.rustyrobot.donow.ui.theme.topAppBarBackgroundColor
import com.rustyrobot.donow.ui.theme.topAppBarContentColor

@Composable
fun ListAppBar() {
    DefaultListAppBar(onSearchClicked = {}, onSortClicked = {}, onDeleteClicked = {})
}

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (priority: Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.tasks),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        actions = {
            ListAppBarActions(
                onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked,
                onDeleteClicked = onDeleteClicked
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (priority: Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    SearchAction(onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
    DeleteAllAction(onDeleteClicked = onDeleteClicked)
}

@Composable
fun SearchAction(onSearchClicked: () -> Unit) {
    IconButton(onClick = { onSearchClicked() }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(R.string.search_tasks),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun SortAction(onSortClicked: (priority: Priority) -> Unit) {

    var expanded by remember {
        mutableStateOf(false)
    }

    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter_list),
            contentDescription = stringResource(R.string.sort_tasks),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.HIGH)
            }) {
                PriorityItem(priority = Priority.HIGH)
            }
            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.MEDIUM)
            }) {
                PriorityItem(priority = Priority.MEDIUM)
            }
            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.LOW)
            }) {
                PriorityItem(priority = Priority.LOW)
            }
            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.NONE)
            }) {
                PriorityItem(priority = Priority.NONE)
            }
        }
    }
}

@Composable
fun DeleteAllAction(onDeleteClicked: () -> Unit) {

    var expanded by remember {
        mutableStateOf(false)
    }

    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_vertical_menu),
            contentDescription = stringResource(R.string.delete_all),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(onClick = {
                expanded = false
                onDeleteClicked()
            }) {
                Text(
                    modifier = Modifier.padding(start = LARGE_PADDING),
                    text = stringResource(R.string.delete_all),
                    style = Typography.subtitle2
                )
            }
        }
    }
}

@Composable
@Preview
private fun DefaultListAppBarPreview() {
    DefaultListAppBar(onSearchClicked = {}, onSortClicked = {}, onDeleteClicked = {})
}