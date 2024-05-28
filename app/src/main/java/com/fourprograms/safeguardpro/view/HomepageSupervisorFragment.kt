package com.fourprograms.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fourprograms.safeguardpro.R
import com.fourprograms.safeguardpro.databinding.FragmentCadastroEpiBinding
import com.fourprograms.safeguardpro.databinding.FragmentHomepageSupervisorBinding

class HomepageSupervisorFragment : Fragment() {

    private var _binding: FragmentHomepageSupervisorBinding? = null
    private val binding: FragmentHomepageSupervisorBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomepageSupervisorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardInventario.setOnClickListener {
            findNavController().navigate(R.id.escolhaEpiFragment)
        }

        binding.cardAtualizacao.setOnClickListener {
            findNavController().navigate(R.id.criarAtualizacaoFragment)
        }

        binding.cardFuncionario.setOnClickListener {
            findNavController().navigate(R.id.cadastroFuncionarioFragment)
        }

        binding.cardNewEpi.setOnClickListener {
            findNavController().navigate(R.id.cadastroEpiFragment)
        }

        binding.cardEntregaEpis.setOnClickListener {
            findNavController().navigate(R.id.entregaFragment)
        }

        binding.cardNewEntrega.setOnClickListener {
            findNavController().navigate(R.id.escolhaEpiFragment)
        }

        binding.cardRelatorioFunc.setOnClickListener {
            findNavController().navigate(R.id.relatorioFuncionarioFragment)
        }

        binding.cardRelatorioEpi.setOnClickListener {
            findNavController().navigate(R.id.relatorioEpiFragment)
        }
    }
}