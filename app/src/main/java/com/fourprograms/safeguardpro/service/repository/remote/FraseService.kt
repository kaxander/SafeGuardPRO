package com.fourprograms.safeguardpro.service.repository.remote

import com.fourprograms.safeguardpro.service.model.FraseResult
import retrofit2.Call
import retrofit2.http.GET

interface FraseService {
    @GET("advice")
    fun getFrase(): Call<FraseResult>
}