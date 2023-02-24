package com.lahsuak.apps.testexample.data

import androidx.room.*
import com.lahsuak.apps.testexample.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    // task methods
    @Query("SELECT * FROM task_table")
    fun getAllTasks() : Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Task)

    @Query("SELECT * FROM TASK_TABLE WHERE id=:taskId")
    suspend fun getById(taskId: Int): Task

    @Query("DELETE FROM TASK_TABLE")
    suspend fun deleteAllTask()
}