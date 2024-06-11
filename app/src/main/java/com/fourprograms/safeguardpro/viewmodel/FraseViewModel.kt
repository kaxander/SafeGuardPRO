package com.fourprograms.safeguardpro.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fourprograms.safeguardpro.service.model.Frase
import com.fourprograms.safeguardpro.service.repository.FraseRepository

class FraseViewModel(application: Application): AndroidViewModel(application) {
    private val fraseRepository = FraseRepository(application)
    private val mFrase = MutableLiveData<Frase>()
    var frase: LiveData<Frase> = mFrase
    private val mErrorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = mErrorMessage

    fun getFrase(){
        fraseRepository.getFrase(
            onSuccess = {frase ->
                mFrase.postValue(frase)
            },
            onFailure = {
                mErrorMessage.postValue(it)
            }
        )
    }
}