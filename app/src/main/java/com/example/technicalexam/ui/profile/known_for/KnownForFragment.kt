package com.example.technicalexam.ui.profile.known_for

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.technicalexam.databinding.FragmentKnownForBinding
import com.example.technicalexam.domain.model.KnownFor

class KnownForFragment(private var knownForList: ArrayList<KnownFor>) : Fragment() {

    private lateinit var binding: FragmentKnownForBinding
    private lateinit var adapterKnownFor: KnownForAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = setViewBinding(inflater, container)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showingAndFillingCart()
    }

    private fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewGroup {
        binding = FragmentKnownForBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initKnownForRecycler() {
        binding.knownForRecycle.apply {
            layoutManager = LinearLayoutManager(
                this.context, LinearLayoutManager.VERTICAL, false
            )
            adapter = adapterKnownFor
        }
    }

    private fun showingAndFillingCart() {
        binding.knownForRecycle.visibility = View.VISIBLE
        adapterKnownFor = KnownForAdapter(knownForList)
        initKnownForRecycler()
    }
}