package com.fourprograms.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.fourprograms.safeguardpro.databinding.FragmentRelatorioFuncionarioBinding
import com.fourprograms.safeguardpro.viewmodel.FuncionarioViewModel

class RelatorioFuncionarioFragment : Fragment() {
    private val viewModel: FuncionarioViewModel by viewModels()

    private var _binding: FragmentRelatorioFuncionarioBinding? = null
    private val binding: FragmentRelatorioFuncionarioBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRelatorioFuncionarioBinding.inflate(inflater, container, false)
        return binding.root
        viewModel.load()
    }
}