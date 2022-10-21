package com.example.technicalexam.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.technicalexam.databinding.FragmentMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = setViewBinding(inflater, container)

    private fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewGroup {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }
}