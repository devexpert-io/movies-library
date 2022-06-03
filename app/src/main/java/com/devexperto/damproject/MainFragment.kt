package com.devexperto.damproject

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.devexperto.damproject.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(FragmentMainBinding.bind(view)) {
            supportActionBar?.title = getString(R.string.app_name)
            recycler.adapter = MoviesAdapter(movies) { movie ->
                findNavController().navigate(
                    R.id.action_main_to_detail,
                    bundleOf(DetailFragment.EXTRA_MOVIE to movie)
                )
            }
        }
    }
}

private val movies =
    (1..100).map { Movie("Title $it", "https://loremflickr.com/240/320/dog?lock=$it") }