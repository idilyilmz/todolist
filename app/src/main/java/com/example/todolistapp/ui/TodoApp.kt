package com.example.todolistapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // <-- Import this
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import com.example.todolistapp.database.entities.TodoEntity
import com.example.todolistapp.viewmodel.TodoViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolistapp.ui.components.TodoItem

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("OPT_IN_USAGE")
@Composable
fun TodoApp(todoViewModel: TodoViewModel) {
    // Observe the allTodos LiveData
    val todos by todoViewModel.allTodos.collectAsState(emptyList())

    var todoTitle by remember { mutableStateOf("") }
    var todoDescription by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("To-Do List") }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Input for new Todo
                TextField(
                    value = todoTitle,
                    onValueChange = { todoTitle = it },
                    label = { Text("Todo Title") },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value = todoDescription,
                    onValueChange = { todoDescription = it },
                    label = { Text("Description") },
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = {
                        todoViewModel.addTodo(TodoEntity(title = todoTitle, description = todoDescription))
                        todoTitle = ""
                        todoDescription = ""
                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("Add Todo")
                }

                // Display Todo List
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(todos) { todo -> // Use the correct items function
                        TodoItem(todo, todoViewModel)
                    }
                }

            }
        }
    )
}
