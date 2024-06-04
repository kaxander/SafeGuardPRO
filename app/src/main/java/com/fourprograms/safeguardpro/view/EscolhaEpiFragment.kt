package com.fourprograms.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fourprograms.safeguardpro.R

class EscolhaEpiFragment : Fragment() {
    private var _binding: FragmentEscolhaEpiBinding? = null

    private val binding: FragmentEscolhaEpiBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEscolhaEpiBinding.inflate(inflater, container, false)
        return binding.root
    }
}