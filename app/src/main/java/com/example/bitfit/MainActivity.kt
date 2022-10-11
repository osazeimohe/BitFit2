package com.example.bitfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val exercises = mutableListOf<Exercise>()
    val ExerciseAdapter = ExerciseAdapter(this, exercises)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addNew = findViewById<Button>(R.id.addNew)
        val titleTextView = findViewById<TextView>(R.id.titleOverview)

        addNew.setOnClickListener(){
            // first parameter is the context, second is the class of the activity to launch
            val i = Intent(this@MainActivity, ExerciseInput::class.java)
            startActivity(i) // brings up the second activity

        }
        // Lookup the recyclerview in activity layout
        val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        // Create adapter passing in the sample user data
        // Attach the adapter to the recyclerview to populate items
        recyclerView.adapter = ExerciseAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            (application as ExerciseApplication).db.exerciseDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    Exercise(
                        entity.title.toString(),
                        entity.lengthOfExercise.toString(),
                        entity.date.toString(),
                        entity.exerciseDescription.toString()
                    )
                }.also { mappedList ->
                    exercises.clear()
                    exercises.addAll(mappedList)
                    ExerciseAdapter.notifyDataSetChanged()
                }
            }
        }


    }
}



