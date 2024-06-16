package com.fourprograms.safeguardpro.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.fourprograms.safeguardpro.service.model.EntregaEpi
import com.fourprograms.safeguardpro.service.model.Epi
import com.fourprograms.safeguardpro.service.repository.EntregaRepository
import com.fourprograms.safeguardpro.service.repository.EpiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EntregaViewModel(application: Application) : AndroidViewModel(application) {

    private val mEntrega = MutableLiveData<EntregaEpi>()
    val emprestimo: LiveData<EntregaEpi> = mEntrega

    private val mCreatedEmprestimo = MutableLiveData<EntregaEpi>()
    val createdEmprestimo: LiveData<EntregaEpi> = mCreatedEmprestimo

    private val repository = EntregaRepository(application)

    private val mEmprestimoList = MutableLiveData<List<EntregaEpi>>()
    val emprestimoList: LiveData<List<EntregaEpi>> = mEmprestimoList

    private val mUpdatedEmpretimo = MutableLiveData<EntregaEpi>()
    val updatedEmprestimo: LiveData<EntregaEpi> = mUpdatedEmpretimo

    private val mDeletedEmprestimo = MutableLiveData<Boolean>()
    val deletedEmprestimo: LiveData<Boolean> = mDeletedEmprestimo

    private val mErro = MutableLiveData<String>()
    val erro: LiveData<String> = mErro

    fun load() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                mEmprestimoList.postValue(repository.selectEmpretimo())
            } catch (e: Exception) {
                mErro.postValue(e.message)
            }
        }
    }

    fun insert(entregaEpi: EntregaEpi) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val createdEmprestimo = repository.insertEmprestimo(entregaEpi)
                mCreatedEmprestimo.postValue(createdEmprestimo)
            } catch (e: Exception) {
                mErro.postValue(e.message)
            }
        }
    }

    fun selectEmprestimo(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                mEntrega.postValue(repository.selectEmprestimo(id))
            } catch (e: Exception) {
                mErro.postValue(e.message)
            }
        }
    }

    fun update(entregaEpi: EntregaEpi) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val updatedEmprestimo = repository.updateEmprestimo(entregaEpi)
                mUpdatedEmpretimo.postValue(updatedEmprestimo)
            } catch (e: Exception) {
                mErro.postValue(e.message)
            }
        }
    }
}