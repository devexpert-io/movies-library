package com.devexperto.damproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.devexperto.damproject.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "DetailActivity:extraMovie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(ActivityDetailBinding.inflate(layoutInflater)) {
            setContentView(root)

            val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)

            if (movie != null) {
                supportActionBar?.title = movie.title
                Glide.with(thumb).load(movie.url).into(thumb)
            }
        }

    }
}