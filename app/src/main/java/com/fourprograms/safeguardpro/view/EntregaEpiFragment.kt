package com.fourprograms.safeguardpro.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fourprograms.safeguardpro.databinding.FragmentEntregaBinding
import com.fourprograms.safeguardpro.databinding.FragmentEntregaEpiBinding

class EntregaEpiFragment : Fragment() {

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
    }
}