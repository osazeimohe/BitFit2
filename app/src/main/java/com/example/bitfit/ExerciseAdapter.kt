package com.example.bitfit

import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
    class ExerciseAdapter(private val context: Context, private val exercises: MutableList<Exercise>): RecyclerView.Adapter<ExerciseAdapter.ViewHolder>() {

        // Provide a direct reference to each of the views within a data item
        // Used to cache the views within the item layout for fast access
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
            val titleTextView: TextView
            val dateTextView: TextView
            val lengthTextView: TextView
            init {
                // Your holder should contain and initialize a member variable
                // for any view that will be set as you render a row
               titleTextView = itemView.findViewById<TextView>(R.id.titleOverview)
                dateTextView = itemView.findViewById<TextView>(R.id.dateOverview)
               lengthTextView  = itemView.findViewById<TextView>(R.id.lengthOfExerciseOverview)
            }

            override fun onClick(v: View?) {
                // Get selected article
                val article = exercises[absoluteAdapterPosition]

                // Navigate to Details screen and pass selected article
                //val intent = Intent(context, DetailActivity::class.java)
                //intent.putExtra(ARTICLE_EXTRA, article)
                //context.startActivity(intent)
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val exerciseView = inflater.inflate(R.layout.exerciseitem, parent, false)
        // Return a new holder instance
        return ViewHolder(exerciseView)
    }

    override fun onBindViewHolder(holder: ExerciseAdapter.ViewHolder, position: Int) {
        val exercise: Exercise = exercises[position]
        holder.titleTextView.text = exercise.title
        holder.dateTextView.text = exercise.date.toString()
        holder.lengthTextView.text = exercise.lengthOfExercise.toString()

    }

    override fun getItemCount(): Int {
       return exercises.size
    }


}