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
import com.fourprograms.safeguardpro.databinding.FragmentRelatorioEpiBinding
import com.fourprograms.safeguardpro.view.adapter.EpiAdapter
import com.fourprograms.safeguardpro.viewmodel.EpiViewModel
import com.fourprograms.safeguardpro.viewmodel.FuncionarioViewModel

class RelatorioEpiFragment : Fragment() {
    private val viewModel: EpiViewModel by viewModels()

    //Chamar adapter
    private lateinit var adapter: EpiAdapter

    private var _binding: FragmentRelatorioEpiBinding? = null
    private val binding: FragmentRelatorioEpiBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        _binding = FragmentRelatorioEpiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Quando clicar em algum item da lista
        adapter = EpiAdapter(listOf(),{
            // padrao das outras adapter
            val epiBundle = Bundle()
            epiBundle.putInt("epiId", it.id)
            arguments = epiBundle
            findNavController().navigate(R.id.cadastroEpiFragment, arguments)
        }, {
            // chamar a funcao delete da viewmodel
            viewModel.delete(it)
        })

        // Configura a recycler
        val recycler = binding.rvRelatorioEpi
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

//        binding.btnAdd.setOnClickListener {
//            findNavController().navigate(R.id.cadastroEpiFragment)
//        }

        // Observa para adicionar um item na lista quando for adiconado
        viewModel.epiList.observe(viewLifecycleOwner) {
            adapter.updateEpis(it)
        }

        viewModel.load()

    }

}
