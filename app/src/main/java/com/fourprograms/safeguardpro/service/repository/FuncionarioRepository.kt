package com.fourprograms.safeguardpro.service.repository

import android.content.Context
import com.fourprograms.safeguardpro.service.model.Funcionario
import com.fourprograms.safeguardpro.service.repository.remote.FuncionarioService
import com.fourprograms.safeguardpro.service.repository.remote.RetrofitClient
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.http.GET

class FuncionarioRepository(context: Context) {
    private val mRemote = RetrofitClient.createService(FuncionarioService::class.java)
    private val funcionarioEmpty = Funcionario(0, "", "", "", "")

    suspend fun selectFuncionarios(): List<Funcionario> {
        return mRemote.selectFuncionarios()
    }

    suspend fun insertFuncionario(funcionario: Funcionario): Funcionario {
        return mRemote.createFuncionario(
            nome = funcionario.nome.toRequestBody("text/plain".toMediaTypeOrNull()),
            email = funcionario.email.toRequestBody("text/plain".toMediaTypeOrNull()),
            telefone = funcionario.telefone.toRequestBody("text/plain".toMediaTypeOrNull()),
            cpf = funcionario.cpf.toRequestBody("text/plain".toMediaTypeOrNull()),
            senha = funcionario.senha.toRequestBody("text/plain".toMediaTypeOrNull()),
            admin = funcionario.admin.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
        ).body() ?: funcionarioEmpty
    }

    suspend fun selectFuncionario(id: Int): Funcionario {
        val response = mRemote.getFuncionarioById(id)
        return if (response.isSuccessful) {
            response.body()?.first() ?: funcionarioEmpty
        } else {
            funcionarioEmpty
        }
    }

    suspend fun selectFuncionarioByCpf(cpf: Int): Funcionario {
        val response = mRemote.getFuncionarioByCpf(cpf)
        return if (response.isSuccessful) {
            response.body()?.first() ?: funcionarioEmpty
        } else {
            funcionarioEmpty
        }
    }

    suspend fun updateFuncionario(funcionario: Funcionario): Funcionario {
        return mRemote.updateFuncionario(
            nome = funcionario.nome.toRequestBody("text/plain".toMediaTypeOrNull()),
            email = funcionario.email.toRequestBody("text/plain".toMediaTypeOrNull()),
            cpf = funcionario.cpf.toRequestBody("text/plain".toMediaTypeOrNull()),
            telefone = funcionario.telefone.toRequestBody("text/plain".toMediaTypeOrNull()),
            senha = funcionario.senha.toRequestBody("text/plain".toMediaTypeOrNull()),
            admin = funcionario.admin.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
            funcionarioId = funcionario.id
        ).body() ?: funcionarioEmpty
    }

    suspend fun deleteFuncionario(id: Int): Boolean {
        return mRemote.deleteFuncionarioById(id).isSuccessful
    }
}