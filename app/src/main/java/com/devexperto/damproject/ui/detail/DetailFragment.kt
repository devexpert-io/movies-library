package com.devexperto.damproject.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.devexperto.damproject.R
import com.devexperto.damproject.databinding.FragmentDetailBinding
import com.devexperto.damproject.ui.loadUrl
import com.devexperto.damproject.ui.supportActionBar

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(FragmentDetailBinding.bind(view)) {
            supportActionBar?.title = args.movie.title
            thumb.loadUrl(args.movie.url)
        }
    }

}