package com.example.todolistapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todolistapp.database.dao.TodoDao

class TodoViewModelFactory(private val todoDao: TodoDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Check if the requested ViewModel class is TodoViewModel
        if (modelClass.isAssignableFrom(TodoViewModel::class.java)) {
            // Suppress the unchecked cast warning since we are confident this cast is safe
            @Suppress("UNCHECKED_CAST")
            return TodoViewModel(todoDao) as T
        }
        // Throw an exception if the ViewModel is of an unknown class
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
