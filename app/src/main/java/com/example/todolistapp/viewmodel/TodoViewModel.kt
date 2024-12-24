// TodoViewModel.kt
package com.example.todolistapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistapp.database.dao.TodoDao
import com.example.todolistapp.database.entities.TodoEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel(private val todoDao: TodoDao) : ViewModel() {

    // LiveData for observing the todos
    private val _allTodos = MutableStateFlow<List<TodoEntity>>(emptyList())
    val allTodos: StateFlow<List<TodoEntity>> = _allTodos

    fun addTodo(todo: TodoEntity) {
        viewModelScope.launch {
            todoDao.insert(todo)
        }
    }

    fun deleteTodoById(todoId: Int) {
        viewModelScope.launch {
            todoDao.deleteById(todoId)
        }
    }
}
