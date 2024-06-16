package com.fourprograms.safeguardpro.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.fourprograms.safeguardpro.databinding.FragmentCadastroEpiBinding
import com.fourprograms.safeguardpro.service.model.Epi
import com.fourprograms.safeguardpro.viewmodel.EpiViewModel

class CadastroEpiFragment : Fragment() {
    private val viewModel: EpiViewModel by viewModels()

    private var _binding: FragmentCadastroEpiBinding? = null

    private val binding: FragmentCadastroEpiBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCadastroEpiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.createdEpi.observe(viewLifecycleOwner) {
            if (it.id == 0) {
                Toast.makeText(
                    requireContext(),
                    "Epi não foi possível ser criada",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Epi ${it.id} criada com sucesso",
                    Toast.LENGTH_LONG
                ).show()
                binding.edttipo.editText?.editableText?.clear()
                binding.edtCa.editText?.editableText?.clear()
                binding.edtDescricao.editText?.editableText?.clear()
                binding.edtValidade.editText?.editableText?.clear()
                binding.edtUsoColetivo.editText?.editableText?.clear()
                findNavController().navigateUp()
            }
        }
        binding.btnCadastrar.setOnClickListener {

            val tipo = binding.edttipo.editText?.editableText.toString()
            val certificado_aprovacao = binding.edtCa.editText?.editableText.toString().toInt()
            val descricao = binding.edtDescricao.editText?.editableText.toString()
            val validade = binding.edtValidade.editText?.editableText.toString()
            val uso_coletivo = binding.edtUsoColetivo.editText?.editableText.toString()



            val epi = Epi(
                tipo = tipo,
                certificado_aprovacao = certificado_aprovacao,
                descricao = descricao,
                validade = validade,
                uso_coletivo = uso_coletivo


            )

            viewModel.epi.value?.let {
                epi.id = it.id
                viewModel.update(epi)
            } ?: run {
                viewModel.insert(epi)
            }

        }


        viewModel.erro.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Erro: $it", Toast.LENGTH_LONG).show()
        }

        viewModel.updatedEpi.observe(viewLifecycleOwner) {
            findNavController().navigateUp()
        }

//        binding.btnDelete.setOnClickListener {
//
//            AlertDialog.Builder(requireContext())
//
//                .setTitle("Exclusão de epi")
//
//                .setMessage("Você realmente deseja excluir essa epi?")
//
//                .setPositiveButton("Sim"){ _,_ ->
//
//                    viewModel.delete(viewModel.epi.value?.id ?: 0)
//
//                }
//
//                .setNegativeButton("Não"){_,_ ->}
//
//                .show()
//
//        }
        viewModel.deletedEpi.observe(viewLifecycleOwner){
            findNavController().navigateUp()
        }
    }


}
