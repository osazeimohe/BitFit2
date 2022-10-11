package com.example.bitfit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises_table")
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "lengthOfExercise") val lengthOfExercise: String?,
    @ColumnInfo(name = "date") val date: String?,
    @ColumnInfo(name = "exerciseDescription") val exerciseDescription: String?
)