package com.fourprograms.safeguardpro.service.repository.remote

import android.adservices.adid.AdId
import com.fourprograms.safeguardpro.service.model.Epi
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface EpiService {

    @GET("select_epi")
    suspend fun selectEpi(): List<Epi>

    @Multipart
    @POST("add_epi")
    suspend fun createEpi(
      @Part("tipo") tipo: RequestBody,
      @Part("descricao") descricao: RequestBody,
      @Part("validade") validade: RequestBody,
      @Part("uso_coletivo") uso_coletivo: RequestBody,
      @Part("certificado_aprovacao") certificado_aprovacao: RequestBody

    ): Response<Epi>

    @GET("select_unica_epi/{id_select_epi}")
    suspend fun getEpiById(@Path("id_select_epi") id: Int): Response<List<Epi>>

    @Multipart
    @PUT("update_epi/{epi_id}")
    suspend fun updateEpi(
        @Path("epi_id") epiId: Int,
        @Part("tipo") tipo: RequestBody,
        @Part("descricao") descricao: RequestBody,
        @Part("validade") validade: RequestBody,
        @Part("uso_coletivo") uso_coletivo: RequestBody,
        @Part("certificado_aprovacao") certificado_aprovacao: RequestBody,

        ): Response<Epi>


    @DELETE("delete_epi/{epi_id}")
    suspend fun deleteEpiById(@Path("epi_id") id: Int): Response<Epi>

}