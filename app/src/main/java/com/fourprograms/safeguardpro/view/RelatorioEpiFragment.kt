package com.fourprograms.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.fourprograms.safeguardpro.databinding.FragmentRelatorioEpiBinding
import com.fourprograms.safeguardpro.viewmodel.FuncionarioViewModel

class RelatorioEpiFragment : Fragment() {
    private val viewModel: FuncionarioViewModel by viewModels()

    private var _binding: FragmentRelatorioEpiBinding? = null
    private val binding: FragmentRelatorioEpiBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        _binding = FragmentRelatorioEpiBinding.inflate(inflater, container, false)
        return binding.root
        viewModel.load()
    }


}
