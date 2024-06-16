package com.fourprograms.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.fourprograms.safeguardpro.R
import com.fourprograms.safeguardpro.databinding.FragmentCadastroEpiBinding
import com.fourprograms.safeguardpro.databinding.FragmentHomePageBinding
import com.fourprograms.safeguardpro.service.model.Login
import com.fourprograms.safeguardpro.viewmodel.FuncionarioViewModel

class HomePageFragment : Fragment() {
    private val viewModelFuncionario: FuncionarioViewModel by viewModels()

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
        var senha = ""
        var cpf = ""

        binding.btnLogar.setOnClickListener {
            cpf = binding.tilCpf.editText?.editableText.toString()
            senha = binding.tilSenha.editText?.editableText.toString()

            if ((cpf.isBlank() || cpf.isEmpty()) || (senha.isBlank() || senha.isEmpty())) {
                Toast.makeText(requireContext(), "Preencha os campos", Toast.LENGTH_LONG).show()
            } else {
                viewModelFuncionario.selectFuncionarioByCpf(cpf.toInt())
            }
        }

        viewModelFuncionario.funcionario.observe(viewLifecycleOwner) {
            if (it.senha == senha && it.cpf == cpf){
                Login.userConected(it.id, it.cpf, it.admin)

                if (it.admin) {
                    findNavController().navigate(R.id.homepageSupervisorFragment)
                } else {
                    findNavController().navigate(R.id.homepageFuncionarioFragment)
                }
            } else {
                Toast.makeText(requireContext(), "Usuario ou senha inválidos", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnCriarConta.setOnClickListener {
            findNavController().navigate(R.id.cadastroSupervisorFragment)
        }
    }
}