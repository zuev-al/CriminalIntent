package com.bignerdranch.android.criminalintent

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bignerdranch.android.criminalintent.databinding.DialogFragmentPhotoBinding

class PhotoDialogFragment(private val photoFileName : String?) : DialogFragment() {
    private var _binding: DialogFragmentPhotoBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = DialogFragmentPhotoBinding.inflate(inflater, container, false)

        binding.crimePhoto.setImageBitmap(BitmapFactory.decodeFile(
                requireContext().filesDir.path + "/" + photoFileName)
            )

        return binding.root
    }
}