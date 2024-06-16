package com.fourprograms.safeguardpro.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.fourprograms.safeguardpro.databinding.FragmentCadastroFuncionarioBinding
import com.fourprograms.safeguardpro.service.model.Funcionario
import com.fourprograms.safeguardpro.viewmodel.FuncionarioViewModel

class CadastroFuncionarioFragment : Fragment() {
    private val viewModel: FuncionarioViewModel by viewModels()

    private var _binding: FragmentCadastroFuncionarioBinding? = null

    private val binding: FragmentCadastroFuncionarioBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCadastroFuncionarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.createdFuncionario.observe(viewLifecycleOwner) {
            if (it.id == 0) {
                Toast.makeText(
                    requireContext(),
                    "Funcionário não foi possível ser criado",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Funcionario ${it.nome} criado com sucesso",
                    Toast.LENGTH_LONG
                ).show()
                binding.edtNome.editText?.editableText?.clear()
                binding.edtCPF.editText?.editableText?.clear()
                binding.edtEmail.editText?.editableText?.clear()
                binding.edtTelefone.editText?.editableText?.clear()
                findNavController().navigateUp()
            }
        }

        binding.btnCadastrar.setOnClickListener {

            val nome = binding.edtNome.editText?.editableText.toString()
            val email = binding.edtEmail.editText?.editableText.toString()
            val cpf = binding.edtCPF.editText?.editableText.toString()
            val telefone = binding.edtTelefone.editText?.editableText.toString()


            val funcionario = Funcionario(
                nome = nome,
                cpf = cpf,
                email = email,
                telefone = telefone


            )

            viewModel.funcionario.value?.let {
                funcionario.id = it.id
                viewModel.update(funcionario)
            } ?: run {
                viewModel.insert(funcionario)
            }

        }



        viewModel.erro.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Erro: $it", Toast.LENGTH_LONG).show()
        }

        viewModel.updatedFuncionario.observe(viewLifecycleOwner) {
            findNavController().navigateUp()
        }

//        binding.btnDelete.setOnClickListener {
//
//            AlertDialog.Builder(requireContext())
//
//                .setTitle("Exclusão de funcionário")
//
//                .setMessage("Você realmente deseja excluir esse funcionário?")
//
//                .setPositiveButton("Sim"){ _,_ ->
//
//                    viewModel.delete(viewModel.funcionario.value?.id ?: 0)
//
//                }
//
//                .setNegativeButton("Não"){_,_ ->}
//
//                .show()
//
//        }

        viewModel.deletedFuncionario.observe(viewLifecycleOwner){
            findNavController().navigateUp()
        }
    }
}

