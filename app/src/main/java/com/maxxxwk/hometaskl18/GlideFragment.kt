package com.maxxxwk.hometaskl18

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maxxxwk.hometaskl18.databinding.GlideFragmentBinding

class GlideFragment : Fragment() {

    private lateinit var binding: GlideFragmentBinding

    companion object {
        fun newInstance() = GlideFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = GlideFragmentBinding.inflate(inflater, container, false)
        setupListeners()
        return binding.root
    }

    private fun setupListeners() {
        binding.btnLoadImage.setOnClickListener {
            loadImage()
        }
    }

    private fun loadImage() {
        binding.ivGlideImage.loadImageAsCircle(getString(R.string.panamera_image_url))
    }

}