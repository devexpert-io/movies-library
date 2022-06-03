package com.devexperto.damproject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.devexperto.damproject.databinding.FragmentMainBinding

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