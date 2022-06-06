package com.devexperto.damproject.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.devexperto.damproject.R
import com.devexperto.damproject.databinding.FragmentDetailBinding
import com.devexperto.damproject.ui.loadUrl
import com.devexperto.damproject.ui.supportActionBar

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val args by navArgs<DetailFragmentArgs>()

    private val viewModel: DetailViewModel by viewModels { DetailViewModelFactory(args.movie) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner) { movie ->
            with(FragmentDetailBinding.bind(view)) {
                supportActionBar?.title = movie.title
                thumb.loadUrl(movie.url)
            }
        }
    }

}