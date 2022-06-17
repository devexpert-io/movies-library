package com.devexperto.damproject.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.devexperto.damproject.R
import com.devexperto.damproject.databinding.FragmentMainBinding
import com.devexperto.damproject.model.server.RemoteConnection
import com.devexperto.damproject.model.server.toDomainMovie
import com.devexperto.damproject.ui.supportActionBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    private val adapter = MoviesAdapter {}

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view).apply {
            supportActionBar?.title = getString(R.string.app_name)
            recycler.adapter = adapter

            lifecycleScope.launch(Dispatchers.Main) {
                val result1 =
                    RemoteConnection.service.listPopularMovies(getString(R.string.api_key)).results
                val result2 =
                    RemoteConnection.service.listMostVotedMovies(getString(R.string.api_key)).results
                val movies = (result1 + result2).map { it.toDomainMovie() }
                adapter.movies = movies
                adapter.notifyDataSetChanged()
            }
        }
    }
}
