package com.fourprograms.safeguardpro.service.repository

import android.content.Context
import android.hardware.camera2.CaptureFailure
import com.fourprograms.safeguardpro.service.model.Frase
import com.fourprograms.safeguardpro.service.model.FraseResult
import com.fourprograms.safeguardpro.service.repository.remote.FraseService
import com.fourprograms.safeguardpro.service.repository.remote.RetrofitClient
import okhttp3.Response
import retrofit2.Call
import retrofit2.Callback

class FraseRepository(context: Context) {
    private val mRemote =
        RetrofitClient.createService(FraseService::class.java)

    fun getFrase(
        onSuccess: (Frase) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call: Call<FraseResult> = mRemote.getFrase()

        call.enqueue(object : Callback<FraseResult> {
            override fun onResponse(call: Call<FraseResult>, response: retrofit2.Response<FraseResult>) {
                if (response.isSuccessful) {
                    response.body()?.let { frase ->
                        onSuccess.invoke(frase.slip)
                    }
                } else {
                    onFailure.invoke(response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<FraseResult>, t: Throwable) {
                t.message?.let { stringMessage ->
                    onFailure.invoke(stringMessage)
                }
            }
        })
    }
}