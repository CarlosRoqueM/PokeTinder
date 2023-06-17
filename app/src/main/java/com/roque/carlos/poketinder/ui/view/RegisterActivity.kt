package com.roque.carlos.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.roque.carlos.poketinder.util.SharedPreferenceUtil
import com.roque.carlos.poketinder.databinding.ActivityRegisterBinding
import com.roque.carlos.poketinder.ui.viewmodel.RegisterViewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerViewModel = RegisterViewModel(this)
        registerViewModel.onCreate()

        registerViewModel.emptyFieldsError.observe(this){
            Toast.makeText(this,"Ingrese los datos del ususario", Toast.LENGTH_SHORT).show()
        }

        registerViewModel.goSuccessActivity.observe(this){
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.btnRegister.setOnClickListener {
            registerViewModel.validateInput(
                binding.edtUserName.text.toString(),
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString(),
                binding.edtPassword2.text.toString()
            )
        }

    }
}