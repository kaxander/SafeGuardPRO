package com.fourprograms.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fourprograms.safeguardpro.R
import com.fourprograms.safeguardpro.databinding.FragmentCadastroSupervisorBinding
import com.fourprograms.safeguardpro.databinding.FragmentCriarAtualizacaoBinding

class CriarAtualizacaoFragment : Fragment() {

    private var _binding: FragmentCriarAtualizacaoBinding? = null
    private val binding: FragmentCriarAtualizacaoBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCriarAtualizacaoBinding.inflate(inflater, container, false)
        return binding.root
    }
}