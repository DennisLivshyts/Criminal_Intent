package com.example.criminalintent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.example.criminalintent.databinding.FragmentCrimeDetailBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
const val ARG_PARAM1 = "param1"
const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CrimeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class CrimeDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentCrimeDetailBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }
    private lateinit var crime: Crime

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            FragmentCrimeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            crimeTitle.doOnTextChanged { text, _, _, _ ->
                //TODO: do we change the _ above?
                crime = crime.copy(title = text.toString())
            }
            //disables button to ensure that it won't respond when user presses it
            //changes appearance to show disabled state
            crimeDate.apply {
                text = crime.date.toString()
                isEnabled = false
            }
            //listening for checkbox changes
            crimeSolved.setOnCheckedChangeListener { _, isChecked ->
                crime = crime.copy(isSolved = isChecked)
            }
        }
    }

    //TODO: fix this
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
