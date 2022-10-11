package com.example.bitfit

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
private fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}

class ExerciseInput: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exerciseinput)

        val titleInput: TextView = findViewById(R.id.title)
        val exercises: TextView = findViewById(R.id.exercises)
        val lengthOfExercise: TextView = findViewById(R.id.lengthOfExercise)
        val date: TextView = findViewById(R.id.date)
        val add: Button = findViewById(R.id.add)

        add.setOnClickListener(){
            //send the data through an intent to main activity
            val titleInput =  titleInput.text.toString()
            val exercises =  exercises.text
            val lengthOfExercise =  lengthOfExercise.text
            val date =  date.text.toString()
            //add data to the database

                lifecycleScope.launch(IO) {
                    (application as ExerciseApplication).db.exerciseDao().insert(
                        ExerciseEntity(
                            title = titleInput,
                            lengthOfExercise = lengthOfExercise.toString(),
                            date = date,
                            exerciseDescription = exercises.toString()
                        )
                    )
                }

            finish()

        }






        // Set title and abstract information for the article
       // titleTextView.text = article.headline
        //bylineTextView.text = article.byline
       // abstractTextView.text = article.abstract


    }



}