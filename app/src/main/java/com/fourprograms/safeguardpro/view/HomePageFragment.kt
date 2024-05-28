package com.fourprograms.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fourprograms.safeguardpro.R
import com.fourprograms.safeguardpro.databinding.FragmentCadastroEpiBinding
import com.fourprograms.safeguardpro.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {
    private var _binding: FragmentHomePageBinding? = null

    private val binding: FragmentHomePageBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogar.setOnClickListener {
            findNavController().navigate(R.id.homepageSupervisorFragment)
        }

        binding.btnCriarConta.setOnClickListener {
            findNavController().navigate(R.id.cadastroSupervisorFragment)
        }
    }
}