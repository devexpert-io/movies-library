package com.devexperto.damproject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.devexperto.damproject.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    companion object {
        const val EXTRA_MOVIE = "DetailFragment:extraMovie"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(FragmentDetailBinding.bind(view)) {

            val movie = arguments?.getParcelable<Movie>(EXTRA_MOVIE)

            if (movie != null) {
                supportActionBar?.title = movie.title
                thumb.loadUrl(movie.url)
            }
        }
    }

}