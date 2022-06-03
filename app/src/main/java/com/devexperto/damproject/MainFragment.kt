package com.devexperto.damproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.devexperto.damproject.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(FragmentMainBinding.bind(view)) {
            (requireActivity() as AppCompatActivity).supportActionBar?.title =
                getString(R.string.app_name)
            recycler.adapter = MoviesAdapter(movies) { movie ->
                navigateTo(movie)
            }
        }
    }

    private fun navigateTo(movie: Movie) {
        val fragment = DetailFragment()
        fragment.arguments = bundleOf(DetailFragment.EXTRA_MOVIE to movie)

        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view, fragment)
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .commit()
    }
}

private val movies =
    (1..100).map { Movie("Title $it", "https://loremflickr.com/240/320/dog?lock=$it") }