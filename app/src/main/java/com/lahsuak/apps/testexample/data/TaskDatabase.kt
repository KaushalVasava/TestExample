package com.lahsuak.apps.testexample.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lahsuak.apps.testexample.model.Task

@Database(
    entities = [Task::class],
    version = 1
)
abstract class TaskDatabase : RoomDatabase() {
    abstract val dao: TaskDao
}