package com.devexperto.damproject.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.devexperto.damproject.model.Movie
import com.devexperto.damproject.R
import com.devexperto.damproject.databinding.FragmentMainBinding
import com.devexperto.damproject.ui.supportActionBar

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(FragmentMainBinding.bind(view)) {
            supportActionBar?.title = getString(R.string.app_name)
            recycler.adapter = MoviesAdapter(movies) { movie ->
                val action = MainFragmentDirections.actionMainToDetail(movie)
                findNavController().navigate(action)
            }
        }
    }
}

private val movies =
    (1..100).map { Movie("Title $it", "https://loremflickr.com/240/320/dog?lock=$it") }