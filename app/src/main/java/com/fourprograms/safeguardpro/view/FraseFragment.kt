package com.fourprograms.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.fourprograms.safeguardpro.R
import com.fourprograms.safeguardpro.databinding.FragmentFraseBinding
import com.fourprograms.safeguardpro.viewmodel.FraseViewModel


class FraseFragment : Fragment() {
    private val viewModel: FraseViewModel by viewModels()
    private var _binding: FragmentFraseBinding? = null
    private val binding: FragmentFraseBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFraseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFrase()
        viewModel.frase.observe(viewLifecycleOwner){
            binding.tvAtualizacao.text = it.advice
        }
        viewModel.errorMessage.observe(viewLifecycleOwner){
            binding.tvAtualizacao.text = it
        }
    }
}