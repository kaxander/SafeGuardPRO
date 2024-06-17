package com.fourprograms.safeguardpro.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fourprograms.safeguardpro.R

import com.fourprograms.safeguardpro.databinding.FragmentEntregaEpiBinding
import com.fourprograms.safeguardpro.view.adapter.EntregaEpiAdapter
import com.fourprograms.safeguardpro.viewmodel.EntregaViewModel
import com.fourprograms.safeguardpro.viewmodel.FuncionarioViewModel

class EntregaEpiFragment : Fragment() {
    private val viewModel:EntregaViewModel by viewModels()
    private lateinit var adapter: EntregaEpiAdapter

    private var _binding: FragmentEntregaEpiBinding? = null
    private val binding: FragmentEntregaEpiBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEntregaEpiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = EntregaEpiAdapter(viewModel.emprestimoList.value){ entregaEpi ->
            val entregaBundle = Bundle()
            entregaBundle.putInt("entregaId", entregaEpi.id)
            arguments = entregaBundle
            findNavController().navigate(R.id.informacoesEntregaEpiFragment, arguments)
        }

        val recycler = binding.rvListEpi
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        viewModel.emprestimoList.observe(viewLifecycleOwner){
            adapter.updateEntregaEpis(it)
        }

        viewModel.load()
    }

}