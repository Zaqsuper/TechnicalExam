package com.example.technicalexam.ui.camera

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.technicalexam.databinding.FragmentCameraBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CameraFragment : Fragment() {

    private lateinit var binding: FragmentCameraBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = setViewBinding(inflater, container)

    private fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewGroup {
        binding = FragmentCameraBinding.inflate(inflater, container, false)
        return binding.root
    }
}