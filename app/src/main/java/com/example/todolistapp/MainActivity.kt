package com.example.todolistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.todolistapp.ui.TodoApp
import com.example.todolistapp.ui.theme.ToDoListAppTheme
import com.example.todolistapp.database.TodoDatabase
import com.example.todolistapp.viewmodel.TodoViewModel
import com.example.todolistapp.viewmodel.TodoViewModelFactory

class MainActivity : ComponentActivity() {

    private lateinit var todoViewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the ViewModel with the custom factory
        todoViewModel = ViewModelProvider(
            this,
            TodoViewModelFactory(TodoDatabase.getDatabase(applicationContext).todoDao())
        ).get(TodoViewModel::class.java)

        // Set content view with TodoApp composable
        setContent {
            ToDoListAppTheme {
                TodoApp(todoViewModel) // Now it should recognize TodoApp correctly
            }
        }
    }
}
