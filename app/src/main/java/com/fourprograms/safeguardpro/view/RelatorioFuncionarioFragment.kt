package com.fourprograms.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fourprograms.safeguardpro.R
import com.fourprograms.safeguardpro.databinding.FragmentRelatorioFuncionarioBinding
import com.fourprograms.safeguardpro.view.adapter.FuncionarioAdapter
import com.fourprograms.safeguardpro.viewmodel.FuncionarioViewModel

class RelatorioFuncionarioFragment : Fragment() {
    private val viewModel: FuncionarioViewModel by viewModels()

    // Chamar o adapter
    private lateinit var adapter: FuncionarioAdapter

    private var _binding: FragmentRelatorioFuncionarioBinding? = null
    private val binding: FragmentRelatorioFuncionarioBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRelatorioFuncionarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FuncionarioAdapter(viewModel.funcionarioList.value){funcionario ->
            val funcionarioBundle = Bundle()
            funcionarioBundle.putInt("funcionarioId", funcionario.id)
            arguments = funcionarioBundle
            findNavController().navigate(R.id.cadastroFuncionarioFragment, arguments)
        }

        // Configura a recycler
        val recycler = binding.rvFuncionario
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        // Observa para adicionar um item na lista quando for adiconado
        viewModel.funcionarioList.observe(viewLifecycleOwner) {
            adapter.updateFuncionarios(it)
        }


        // Navegar para a tela de cadastro de funcionario
//        binding.btnAdd.setOnClickListener{
//            findNavController().navigate(R.id.cadastroFuncionarioFragment)
//        }

        // Carregar as funcionarios cadastradas
        viewModel.load()
    }
}