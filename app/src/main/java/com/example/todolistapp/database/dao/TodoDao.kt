package com.example.todolistapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todolistapp.database.entities.TodoEntity

@Dao
interface TodoDao {

    // This should return LiveData<List<TodoEntity>>
    @Query("SELECT * FROM todo_table")
    fun getAllTodos(): LiveData<List<TodoEntity>>

    @Insert
    suspend fun insert(todo: TodoEntity)

    @Query("DELETE FROM todo_table WHERE id = :todoId")
    suspend fun deleteById(todoId: Int)
}
