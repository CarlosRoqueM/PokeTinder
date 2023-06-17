package com.roque.carlos.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.roque.carlos.poketinder.util.SharedPreferenceUtil
import com.roque.carlos.poketinder.data.model.User
import com.roque.carlos.poketinder.databinding.ActivityLoginBinding
import com.roque.carlos.poketinder.ui.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel=LoginViewModel(this)
        loginViewModel.onCreate()

        loginViewModel.emptyFieldsError.observe(this){
            Toast.makeText(this,"Ingrese los datos del ususario", Toast.LENGTH_SHORT).show()
        }
        loginViewModel.goSuccessActivity.observe(this){
            startActivity(Intent(this, MainActivity::class.java))
        }
        loginViewModel.fieldsAuthenticateError.observe(this){
           Toast.makeText(this, "Error de usuario", Toast.LENGTH_SHORT).show()
       }

        binding.btnLogin.setOnClickListener {
            loginViewModel.validateInput(
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString()
            )
        }
    }
}