package com.fourprograms.safeguardpro.service.repository.remote

import android.adservices.adid.AdId
import android.provider.ContactsContract.CommonDataKinds.Email
import com.fourprograms.safeguardpro.service.model.Funcionario
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface FuncionarioService {

    @GET("select_funcionarios")
    suspend fun selectFuncionarios(): List<Funcionario>

    @Multipart
    @POST("add_funcionario")
    suspend fun createFuncionario(
        @Part("nome") nome: RequestBody,
        @Part("email") email: RequestBody,
        @Part("telefone") telefone: RequestBody,
        @Part("cpf") cpf: RequestBody

    ): Response<Funcionario>

    @GET("select_unico_funcionario/{id_select_funcionario}")
    suspend fun getFuncionarioById(@Path("id_select_funcionario") id: Int): Response<List<Funcionario>>

    @Multipart
    @PUT("update_funcionario/{funcionario_id}")
    suspend fun updateFuncionario(
        @Path("funcionario_id") funcionarioId: Int,

        @Part("nome") nome: RequestBody,

        @Part("email") email: RequestBody,

        @Part("cpf") cpf: RequestBody,

        @Part("telefone") telefone: RequestBody,

        ): Response<Funcionario>


    @DELETE("delete_funcionario/{funcionario_id}")
    suspend fun deleteFuncionarioById(@Path("funcionario_id") id: Int): Response<Funcionario>
}
