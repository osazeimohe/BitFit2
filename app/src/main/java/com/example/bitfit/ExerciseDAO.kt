package com.example.bitfit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDAO{
    @Query("SELECT * FROM exercises_table")
    fun getAll(): Flow<List<ExerciseEntity>>

    @Insert
    fun insert(exercises: ExerciseEntity)

    @Query("DELETE FROM exercises_table")
    fun deleteAll()
}