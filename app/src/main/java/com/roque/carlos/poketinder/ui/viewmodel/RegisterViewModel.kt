package com.roque.carlos.poketinder.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roque.carlos.poketinder.util.SharedPreferenceUtil

class RegisterViewModel(private val context: Context): ViewModel() {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    val emptyFieldsError = MutableLiveData<Boolean>()

    val goSuccessActivity = MutableLiveData<Boolean>()


    fun onCreate(){
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }
    fun validateInput(email: String, password: String, password2: String, username: String){
        if ( username.isEmpty() || email.isEmpty()|| password.isEmpty()||password2.isEmpty() ){
            emptyFieldsError.postValue(true)
        }
    }
}