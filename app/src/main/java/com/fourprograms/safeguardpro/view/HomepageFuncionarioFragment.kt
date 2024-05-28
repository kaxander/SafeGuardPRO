package com.fourprograms.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fourprograms.safeguardpro.R
import com.fourprograms.safeguardpro.databinding.FragmentCadastroEpiBinding
import com.fourprograms.safeguardpro.databinding.FragmentHomepageFuncionarioBinding

class HomepageFuncionarioFragment : Fragment() {

    private var _binding: FragmentHomepageFuncionarioBinding? = null
    private val binding: FragmentHomepageFuncionarioBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomepageFuncionarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mcvNoticia.setOnClickListener {
            findNavController().navigate(R.id.informacoesFragment)
        }

        binding.mcvEpi.setOnClickListener {
            findNavController().navigate(R.id.entregaEpi)
        }
    }
}