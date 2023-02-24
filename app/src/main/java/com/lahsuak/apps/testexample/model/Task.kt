package com.lahsuak.apps.testexample.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var title: String,
    var isDone: Boolean = false
)