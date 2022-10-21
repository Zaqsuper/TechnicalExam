package com.example.technicalexam.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.technicalexam.databinding.FragmentMapBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapFragment : Fragment() {

    private lateinit var binding: FragmentMapBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = setViewBinding(inflater, container)

    private fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewGroup {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }
}