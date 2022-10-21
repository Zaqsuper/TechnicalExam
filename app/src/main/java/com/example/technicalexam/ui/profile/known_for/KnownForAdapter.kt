package com.example.technicalexam.ui.profile.known_for

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.technicalexam.R
import com.example.technicalexam.databinding.AdapterItemKnownForBinding
import com.example.technicalexam.domain.model.KnownFor
import com.example.technicalexam.ui.Constants
import com.squareup.picasso.Picasso

class KnownForAdapter(private var knownForList: ArrayList<KnownFor>) :
    RecyclerView.Adapter<KnownForAdapter.KnownForHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KnownForHolder =
        KnownForHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_item_known_for, parent, false)
        )

    override fun getItemCount(): Int = knownForList.size

    override fun onBindViewHolder(holder: KnownForHolder, position: Int) {
        val knownFor = knownForList[position]
        setCardKnownForInfo(holder, knownFor)
    }

    private fun setCardKnownForInfo(holder: KnownForHolder, knownFor: KnownFor) {
        holder.binding.apply {
            titleText.text = knownFor.title
            overviewText.text = knownFor.overview
            releaseDateText.text = knownFor.releaseDate
            voteAverageText.text = knownFor.voteAverage
            Picasso.get()
                .load(Constants.BASE_URL_IMAGE + knownFor.posterPath)
                .placeholder(R.drawable.profile_placeholder)
                .error(R.drawable.profile_placeholder)
                .into(movieImage)
        }
    }

    class KnownForHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = AdapterItemKnownForBinding.bind(view)
    }
}