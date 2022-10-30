package com.rustyrobot.donow.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rustyrobot.donow.data.models.Priority
import com.rustyrobot.donow.data.models.ToDoTask
import com.rustyrobot.donow.data.repositories.ToDoRepository
import com.rustyrobot.donow.util.Constants.MAX_TITLE_LENGTH
import com.rustyrobot.donow.util.RequestState
import com.rustyrobot.donow.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val repository: ToDoRepository) : ViewModel() {

    val id: MutableState<Int> = mutableStateOf(0)
    val title: MutableState<String> = mutableStateOf("")
    val description: MutableState<String> = mutableStateOf("")
    val priority: MutableState<Priority> = mutableStateOf(Priority.LOW)

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf("")

    private val _allTasks = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)
    val allTasks: StateFlow<RequestState<List<ToDoTask>>> = _allTasks

    private val _selectedTask: MutableStateFlow<ToDoTask?> = MutableStateFlow(null)
    val selectedTask: StateFlow<ToDoTask?> = _selectedTask

    fun getAllTasks() {
        _allTasks.value = RequestState.Loading
        try {
            viewModelScope.launch {
                repository.getAllTasks().collect {
                    _allTasks.value = RequestState.Success(it)
                }
            }
        } catch (error: Exception) {
            _allTasks.value = RequestState.Error(error)
        }
    }

    fun getTask(taskId: Int) {
        viewModelScope.launch {
            repository.getSelectedTask(taskId = taskId).collect { task ->
                _selectedTask.value = task
            }
        }
    }

    fun updateTaskFields(selectedTask: ToDoTask?) {
        id.value = selectedTask?.id ?: 0
        title.value = selectedTask?.title ?: ""
        description.value = selectedTask?.description ?: ""
        priority.value = selectedTask?.priority ?: Priority.LOW

    }

    fun updateTitle(newTitle: String) {
        if (newTitle.length <= MAX_TITLE_LENGTH) {
            title.value = newTitle
        }
    }
}