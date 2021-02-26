package com.example.oma.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.oma.R
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_login.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    private val PASSWORD_PATTERN: Pattern = Pattern.compile(
        "^" +
                "(?=.*[@#$%^&+=])" +  // at least 1 special character
                "(?=\\S+$)" +  // no white spaces
                ".{4,}" +  // at least 4 characters
                "$"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener {
            if (validateEmail() and validatePassword()) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        }

    }


    private fun validateEmail(): Boolean {

        val emailInput = ed_email!!.text.toString().trim { it <= ' ' }
        return if (emailInput.isEmpty()) {
            ed_email!!.error = "Field can not be empty"
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            ed_email!!.error = "Please enter a valid email address"
            false
        } else {
            ed_email!!.error = null
            true
        }
    }

    private fun validatePassword(): Boolean {
        val passwordInput = ed_pwd!!.text.toString().trim { it <= ' ' }
        return if (passwordInput.isEmpty()) {
            ed_pwd!!.error = "Field can not be empty"
            false
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            ed_pwd!!.error = "Password is too weak"
            false
        } else {
            ed_pwd!!.error = null
            true
        }
    }


}