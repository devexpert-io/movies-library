package com.devexperto.damproject.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.devexperto.damproject.R
import com.devexperto.damproject.databinding.FragmentMainBinding
import com.devexperto.damproject.model.MoviesProvider
import com.devexperto.damproject.ui.supportActionBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    private val adapter = MoviesAdapter { movie ->
        val action = MainFragmentDirections.actionMainToDetail(movie)
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view).apply {
            supportActionBar?.title = getString(R.string.app_name)
            recycler.adapter = adapter
        }

        if (adapter.itemCount == 0) {
            loadItems()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadItems() {
        viewLifecycleOwner.lifecycleScope.launch {
            binding.progress.visibility = View.VISIBLE
            val dogs = async(Dispatchers.IO) { MoviesProvider.getMovies("dogs") }
            val cats = async(Dispatchers.IO) { MoviesProvider.getMovies("cats") }
            adapter.movies = dogs.await() + cats.await()
            adapter.notifyDataSetChanged()
            binding.progress.visibility = View.GONE
        }
    }
}

