package com.example.registrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.view.marginTop

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val passwordConfirmationEditText: EditText = findViewById(R.id.passwordConfirmationEditText)
        val loginButton: Button = findViewById(R.id.loginButton)
        val registerButton: Button = findViewById(R.id.registerButton)
        val goBackButton: Button = findViewById(R.id.goBackButton)


        loginButton.setOnClickListener {
            emailEditText.visibility = View.VISIBLE
            passwordEditText.visibility = View.VISIBLE
            goBackButton.visibility = View.VISIBLE
            registerButton.visibility = View.GONE
            loginButton.setOnClickListener {
                if (emailEditText.text.toString() == "" || passwordEditText.text.toString() == "") {
                    Toast.makeText(this, "Please, fill the form properly", Toast.LENGTH_SHORT).show()
                } else {
                    emailEditText.setText("")
                    passwordEditText.setText("")
                    Toast.makeText(this, "Successfully logged in", Toast.LENGTH_SHORT).show()
                }
            }
        }

        registerButton.setOnClickListener {
            emailEditText.visibility = View.VISIBLE
            passwordEditText.visibility = View.VISIBLE
            passwordConfirmationEditText.visibility = View.VISIBLE
            goBackButton.visibility = View.VISIBLE
            loginButton.visibility = View.GONE
            registerButton.setOnClickListener {
                if (emailEditText.text.toString() == "" || passwordEditText.text.toString() == "" || passwordConfirmationEditText.text.toString() == "") {
                    Toast.makeText(this, "Please, fill the form properly", Toast.LENGTH_SHORT).show()
                } else if (passwordEditText.text.toString() != passwordConfirmationEditText.text.toString()) {
                    Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show()
                } else {
                    emailEditText.setText("")
                    passwordEditText.setText("")
                    passwordConfirmationEditText.setText("")
                    Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show()
                }
            }
        }

        goBackButton.setOnClickListener {
            emailEditText.visibility = View.GONE
            passwordEditText.visibility = View.GONE
            passwordConfirmationEditText.visibility = View.GONE
            registerButton.visibility = View.VISIBLE
            loginButton.visibility = View.VISIBLE
            goBackButton.visibility = View.GONE

        }
    }
}