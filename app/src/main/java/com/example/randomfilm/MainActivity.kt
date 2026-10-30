package com.example.randomfilm

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity : AppCompatActivity() {

    var movies: Array<String> = emptyArray()

    var remainingMovies = mutableListOf<String>()

    val r = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movies = resources.getStringArray(R.array.movies)

        resetMovies()
    }

    fun onNextClick(view: View) {
        val tvTitle = findViewById<TextView>(R.id.title)

        if (remainingMovies.isEmpty()) {
            tvTitle.text = getString(R.string.no_more_movies)
            return
        }

        val index = r.nextInt(remainingMovies.size)
        val selected = remainingMovies.removeAt(index)
        tvTitle.text = selected
    }

    fun onResetClick(view: View) {
        val tvTitle = findViewById<TextView>(R.id.title)
        resetMovies()
        tvTitle.text = getString(R.string.empty_hint)
    }

    fun resetMovies() {
        remainingMovies.clear()
        remainingMovies.addAll(movies)
    }
}