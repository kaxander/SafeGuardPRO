package com.fourprograms.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fourprograms.safeguardpro.R
import com.fourprograms.safeguardpro.databinding.FragmentCadastroEpiBinding
import com.fourprograms.safeguardpro.databinding.FragmentCadastroFuncionarioBinding

class CadastroFuncionarioFragment : Fragment() {

    private var _binding: FragmentCadastroFuncionarioBinding? = null

    private val binding: FragmentCadastroFuncionarioBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCadastroFuncionarioBinding.inflate(inflater, container, false)
        return binding.root
    }
}