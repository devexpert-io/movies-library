package com.devexperto.damproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devexperto.damproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(ActivityMainBinding.inflate(layoutInflater)) {
            setContentView(root)
            recycler.adapter = MoviesAdapter(movies) { movie ->
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_MOVIE, movie)
                startActivity(intent)
            }
        }
    }

}

private val movies =
    (1..100).map { Movie("Title $it", "https://loremflickr.com/240/320/dog?lock=$it") }