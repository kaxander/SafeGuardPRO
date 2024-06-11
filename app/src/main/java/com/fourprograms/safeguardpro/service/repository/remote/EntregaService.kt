package com.fourprograms.safeguardpro.service.repository.remote

import android.adservices.adid.AdId
import android.provider.ContactsContract.CommonDataKinds.Email
import com.fourprograms.safeguardpro.service.model.EntregaEpi
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface EntregaService {

    @GET("select_emprestimo")
    suspend fun selectEmprestimo(): List<EntregaEpi>

    @Multipart
    @POST("add_emprestimo")
    suspend fun createEmprestimo(
        @Part("validade") validade: RequestBody,
        @Part("id_funcionario") id_funcionario: RequestBody,
        @Part("id_epi") id_epi: RequestBody,
        @Part("funcionario") funcionario: RequestBody,
        @Part("epi") epi: RequestBody

    ): Response<EntregaEpi>

    @GET("select_unico_emprestimo/{id_select_emprestimo}")
    suspend fun getEmprestimoById(@Path("id_select_emprestimo") id: Int): Response<List<EntregaEpi>>

    @Multipart
    @PUT("update_emprestimo/{emprestimo_id}")
    suspend fun updateEmprestimo(
        @Path("emprestimo_id") emprestimoId: Int,

        @Part("validade") validade: RequestBody,

        @Part("id_funcionario") id_funcionario: RequestBody,

        @Part("id_epi") id_epi: RequestBody,

        @Part("funcionario") funcionario: RequestBody,

        @Part("epi") epi: RequestBody

        ): Response<EntregaEpi>


    @DELETE("delete_emprestimo/{emprestimo_id}")
    suspend fun deleteEmprestimoById(@Path("emprestimo_id") id: Int): Response<EntregaEpi>
}
