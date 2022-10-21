package com.example.technicalexam.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.technicalexam.R
import com.example.technicalexam.databinding.FragmentProfileBinding
import com.example.technicalexam.domain.model.KnownFor
import com.example.technicalexam.domain.model.Person
import com.example.technicalexam.ui.Constants
import com.example.technicalexam.ui.profile.known_for.KnownForFragment
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val profileViewModel: ProfileViewModel by viewModels()
    private lateinit var knownForFragment: KnownForFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = setViewBinding(inflater, container)

    private fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewGroup {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPopularPeople()
    }

    private fun getPopularPeople() {
        profileViewModel.getPopularPeople()
        profileViewModel.getPopularPeopleState.observe(viewLifecycleOwner) { popularPeopleState ->
            validatePopularPeopleState(popularPeopleState)
        }
    }

    private fun validatePopularPeopleState(state: GetPopularPeopleState) {
        if (state.isLoading) binding.loadingProgressBar.visibility = View.VISIBLE
        else binding.loadingProgressBar.visibility = View.GONE
        state.data?.let {
            setProfileInfo(validateTheMostPopular(it))
        } ?: run {
            if (state.error.isNotBlank())
                Toast.makeText(context, state.error, Toast.LENGTH_LONG).show()
        }
    }

    private fun validateTheMostPopular(people: ArrayList<Person>): Person {
        var popular = Person()
        people.forEachIndexed { index, person ->
            if (index == 0) popular = person
            else if (person.popularity > popular.popularity) popular = person
        }
        return popular
    }

    private fun setProfileInfo(popular: Person) {
        binding.apply {
            nameActorText.text = popular.name
            idActorText.text = popular.id.toString()
            actorPopularityText.text = popular.popularity.toString() + " ★"
            Picasso.get()
                .load(Constants.BASE_URL_IMAGE + popular.profilePath)
                .placeholder(R.drawable.profile_placeholder)
                .error(R.drawable.profile_placeholder)
                .into(profileImage)
        }
        setKnownForInfo(popular.knownFor)
    }

    private fun setKnownForInfo(knownForList: ArrayList<KnownFor>) {
        binding.knownForFrame.visibility = View.VISIBLE
        if (!this::knownForFragment.isInitialized) {
            knownForFragment = KnownForFragment(knownForList)
            childFragmentManager.beginTransaction()
                .replace(
                    binding.knownForFrame.id,
                    knownForFragment
                ).commit()
        }
    }
}