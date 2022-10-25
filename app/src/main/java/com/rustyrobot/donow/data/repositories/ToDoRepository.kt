package com.rustyrobot.donow.data.repositories

import com.rustyrobot.donow.data.ToDoDao
import com.rustyrobot.donow.data.models.ToDoTask
import javax.inject.Inject

class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {

    fun getAllTasks() = toDoDao.getAllTasks()
    fun sortByLowPriority() = toDoDao.sortByLowPriority()
    fun sortByHighPriority() = toDoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int) = toDoDao.getSelectedTask(taskId)

    suspend fun addTask(toDoTask: ToDoTask) = toDoDao.addTask(toDoTask)
    suspend fun updateTask(toDoTask: ToDoTask) = toDoDao.updateTask(toDoTask)
    suspend fun deleteTask(toDoTask: ToDoTask) = toDoDao.deleteTask(toDoTask)

    suspend fun deleteAllTasks() = toDoDao.deleteAllTasks()

    fun searchInDatabase(searchQuery: String) = toDoDao.searchInDatabase(searchQuery)
}