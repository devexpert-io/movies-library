package com.devexperto.damproject.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.devexperto.damproject.R
import com.devexperto.damproject.databinding.FragmentMainBinding
import com.devexperto.damproject.model.server.RemoteConnection
import com.devexperto.damproject.ui.supportActionBar
import kotlinx.coroutines.launch

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModels()

    private val adapter = MoviesAdapter { viewModel.onMovieClicked(it) }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view).apply {
            supportActionBar?.title = getString(R.string.app_name)
            recycler.adapter = adapter

            viewModel.state.observe(viewLifecycleOwner) { state ->
                progress.visibility = if (state.loading) View.VISIBLE else View.GONE
                state.movies?.let {
                    adapter.movies = it
                    adapter.notifyDataSetChanged()
                }
                state.navigateTo?.let {
                    val action = MainFragmentDirections.actionMainToDetail(it)
                    findNavController().navigate(action)
                    viewModel.onNavigationDone()
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            val movies = RemoteConnection.service.listPopularMovies(getString(R.string.api_key))
            Toast.makeText(requireContext(), movies.results.size.toString(), Toast.LENGTH_LONG)
                .show()
        }
    }
}

