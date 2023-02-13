package com.example.movieapiretrofit.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.movieapiretrofit.R
import com.example.movieapiretrofit.api.Repository
import com.example.movieapiretrofit.databinding.FragmentFilterBinding
import com.example.movieapiretrofit.extensions.getTextButtonChecked
import com.example.movieapiretrofit.extensions.getTextChipChecked
import com.example.movieapiretrofit.extensions.setButtonChecked
import com.example.movieapiretrofit.extensions.setChipChecked
import com.example.movieapiretrofit.ui.SharedViewModel
import com.example.movieapiretrofit.ui.SharedViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FilterFragment : BottomSheetDialogFragment() {

   private var fbinding: FragmentFilterBinding? = null
    private val binding get() = fbinding!!
    private val sharedViewModel: SharedViewModel by activityViewModels{SharedViewModelFactory(
        Repository()
    )}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentFilterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
        sharedViewModel.filterValue.observe(viewLifecycleOwner) { item ->
                chipgroupStatus.setChipChecked(item[0])
                radioGroupGender.setButtonChecked(item[1])
        }

            clearRadioChek.setOnClickListener { radioGroupGender.clearCheck() }

            btnApplyFilter.setOnClickListener {

                if(chipgroupStatus.getTextChipChecked().isNotEmpty()&&
                    radioGroupGender.getTextButtonChecked().isNotEmpty()){
                    sharedViewModel.getByStatusAndGender(chipgroupStatus.getTextChipChecked(),
                        radioGroupGender.getTextButtonChecked(),1)
                }
                else{
                    if (chipgroupStatus.getTextChipChecked().isNotEmpty()){
                        sharedViewModel.getByStatus(chipgroupStatus.getTextChipChecked(),1)
                    }
                    else{
                        sharedViewModel.getByGender(radioGroupGender.getTextButtonChecked(),1)
                    }
                }

                sharedViewModel.filterValue.value = arrayOf(chipgroupStatus.checkedChipId,
                    radioGroupGender.checkedRadioButtonId)

            findNavController().popBackStack(R.id.listFragment, false)
        }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

}