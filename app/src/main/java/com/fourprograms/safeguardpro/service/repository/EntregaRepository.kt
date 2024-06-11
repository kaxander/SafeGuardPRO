package com.fourprograms.safeguardpro.service.repository

import android.content.Context
import com.fourprograms.safeguardpro.service.model.EntregaEpi
import com.fourprograms.safeguardpro.service.repository.remote.EntregaService
import com.fourprograms.safeguardpro.service.repository.remote.FuncionarioService
import com.fourprograms.safeguardpro.service.repository.remote.RetrofitClient
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.http.GET

class EntregaRepository(context: Context) {
    private val mRemote = RetrofitClient.createService(EntregaService::class.java)
    private val emprestimoEmpty = EntregaEpi(0, "", 0, "", 0, "")

    suspend fun selectEmpretimo(): List<EntregaEpi> {
        return mRemote.selectEmprestimo()
    }

    suspend fun insertEmprestimo(entregaEpi: EntregaEpi): EntregaEpi {
        return mRemote.createEmprestimo(
            validade = entregaEpi.validade.toRequestBody("text/plain".toMediaTypeOrNull()),
            funcionario = entregaEpi.funcionario.toRequestBody("text/plain".toMediaTypeOrNull()),
            epi = entregaEpi.epi.toRequestBody("text/plain".toMediaTypeOrNull()),
            id_epi = entregaEpi.id_epi.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
            id_funcionario = entregaEpi.id_funcionario.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
        ).body() ?: emprestimoEmpty
    }

    suspend fun selectEmprestimo(id: Int): EntregaEpi {
        val response = mRemote.getEmprestimoById(id)
        return if (response.isSuccessful) {
            response.body()?.first() ?: emprestimoEmpty
        } else {
            emprestimoEmpty
        }
    }

    suspend fun updateEmprestimo(entregaEpi: EntregaEpi): EntregaEpi {

        return mRemote.updateEmprestimo(

            validade = entregaEpi.validade.toRequestBody("text/plain".toMediaTypeOrNull()),

            funcionario = entregaEpi.funcionario.toRequestBody("text/plain".toMediaTypeOrNull()),

            epi = entregaEpi.epi.toRequestBody("text/plain".toMediaTypeOrNull()),

            id_funcionario = entregaEpi.id_funcionario.toString().toRequestBody("text/plain".toMediaTypeOrNull()),

            id_epi = entregaEpi.id_epi.toString().toRequestBody("text/plain".toMediaTypeOrNull()),

            emprestimoId = entregaEpi.id

        ).body() ?: emprestimoEmpty

    }

}