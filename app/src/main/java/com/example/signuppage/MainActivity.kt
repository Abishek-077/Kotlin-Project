package com.example.signuppage//package com.example.loginpage

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import android.util.Patterns
import com.example.signuppage.R

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        // Initialize the input fields
        val firstName = findViewById<TextInputEditText>(R.id.firstName)
        val lastName = findViewById<TextInputEditText>(R.id.lastName)
        val email = findViewById<TextInputEditText>(R.id.email)
        val password = findViewById<TextInputEditText>(R.id.password)

        // Initialize the sign-up button
        val signUpButton = findViewById<Button>(R.id.signUpButton)

        signUpButton.setOnClickListener { v: View? ->
            val firstNameText = firstName.text.toString()
            val lastNameText = lastName.text.toString()
            val emailText = email.text.toString()
            val passwordText = password.text.toString()

            // Validate input fields
            when {
                firstNameText.isEmpty() -> {
                    firstName.error = "First name is required"
                }
                lastNameText.isEmpty() -> {
                    lastName.error = "Last name is required"
                }
                emailText.isEmpty() -> {
                    email.error = "Email is required"
                }
                !Patterns.EMAIL_ADDRESS.matcher(emailText).matches() -> {
                    email.error = "Invalid email address"
                }
                passwordText.isEmpty() -> {
                    password.error = "Password is required"
                }
                passwordText.length < 6 -> {
                    password.error = "Password must be at least 6 characters"
                }
                else -> {
                    // Handle successful sign-up
                    Toast.makeText(this@FormActivity, "Sign-Up Successful", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}



