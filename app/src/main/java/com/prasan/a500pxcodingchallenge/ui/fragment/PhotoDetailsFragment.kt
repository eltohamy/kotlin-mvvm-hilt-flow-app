package com.prasan.a500pxcodingchallenge.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.prasan.a500pxcodingchallenge.databinding.FragmentPhotoDetailsBinding
import com.prasan.a500pxcodingchallenge.model.datamodel.PhotoDetails
import com.prasan.a500pxcodingchallenge.ui.viewmodel.MainViewModel


class PhotoDetailsFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels<MainViewModel>()
    private lateinit var binding: FragmentPhotoDetailsBinding
    private var photo: PhotoDetails? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotoDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        photo = arguments?.getParcelable<PhotoDetails>("photoDetails")
        photo?.let {
            binding.photoDetails = it
        }
    }
}