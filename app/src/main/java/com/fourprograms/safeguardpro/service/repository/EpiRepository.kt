package com.fourprograms.safeguardpro.service.repository

import android.content.Context
import com.fourprograms.safeguardpro.service.model.Epi
import com.fourprograms.safeguardpro.service.repository.remote.EpiService
import com.fourprograms.safeguardpro.service.repository.remote.RetrofitClient
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

class EpiRepository(context: Context) {
    private val mRemote = RetrofitClient.createService(EpiService::class.java)
    private val epiEmpty = Epi(0, "", "", "", "")

    suspend fun selectEpi(): List<Epi> {
        return mRemote.selectEpi()
    }

    suspend fun insertEpi(epi: Epi): Epi {
        return mRemote.createEpi(
            tipo = epi.tipo.toRequestBody("text/plain".toMediaTypeOrNull()),
            descricao = epi.descricao.toRequestBody("text/plain".toMediaTypeOrNull()),
            validade = epi.validade.toRequestBody("text/plain".toMediaTypeOrNull()),
            uso_coletivo = epi.uso_coletivo.toRequestBody("text/plain".toMediaTypeOrNull()),
            certificado_aprovacao = epi.certificado_aprovacao.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
        ).body() ?: epiEmpty
    }

    suspend fun selectEpi(id: Int): Epi {
        val response = mRemote.getEpiById(id)
        return if (response.isSuccessful) {
            response.body()?.first() ?: epiEmpty
        } else {
            epiEmpty
        }
    }

    suspend fun selectEpiByCa(ca: Int): Epi {
        val response = mRemote.getEpiByCa(ca)
        return if (response.isSuccessful) {
            response.body()?.first() ?: epiEmpty
        } else {
            epiEmpty
        }
    }

    suspend fun updateEpi(epi: Epi): Epi {
        return mRemote.updateEpi(
            tipo = epi.tipo.toRequestBody("text/plain".toMediaTypeOrNull()),
            descricao = epi.descricao.toRequestBody("text/plain".toMediaTypeOrNull()),
            validade = epi.validade.toRequestBody("text/plain".toMediaTypeOrNull()),
            uso_coletivo = epi.uso_coletivo.toRequestBody("text/plain".toMediaTypeOrNull()),
            certificado_aprovacao = epi.certificado_aprovacao.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
            epiId = epi.id
        ).body() ?: epiEmpty
    }

    suspend fun deleteEpi(id: Int): Boolean {
        return mRemote.deleteEpiById(id).isSuccessful
    }
}