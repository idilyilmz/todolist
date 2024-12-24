package com.example.todolistapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolistapp.database.entities.TodoEntity
import com.example.todolistapp.viewmodel.TodoViewModel

@Composable
fun TodoItem(todo: TodoEntity, todoViewModel: TodoViewModel, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(
            text = todo.title,
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge
        )
        Text(
            text = todo.description,
            style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
        )
    }
}