package com.abidnabil.regifrom

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var titleSpinner: Spinner
    private lateinit var firstNameTextBox: TextInputEditText
    private lateinit var lastNameTextBox: TextInputEditText
    private lateinit var emailTextBox: TextInputEditText
    private lateinit var phoneTextBox: TextInputEditText
    private lateinit var passwordTextBox: TextInputEditText
    private lateinit var submitButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getViews()
        val jobTitles = arrayOf("Junior Software Engineer", "Manager", "HR")
        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, jobTitles)
        titleSpinner.adapter = spinnerAdapter
        submitButton.setOnClickListener {
            submitForm()
        }


    }

    private fun getViews() {
        titleSpinner = findViewById(R.id.spinner_user_title)
        firstNameTextBox = findViewById(R.id.text_view_first_name)
        lastNameTextBox = findViewById(R.id.text_view_last_name)
        emailTextBox = findViewById(R.id.text_view_email)
        phoneTextBox = findViewById(R.id.text_view_phone)
        passwordTextBox = findViewById(R.id.text_view_password)
        submitButton = findViewById(R.id.button_submit)
    }

    private fun submitForm() {
        val user = User(
            titleSpinner.selectedItem.toString(),
            firstNameTextBox.text.toString() + " " + lastNameTextBox.text.toString(),
            emailTextBox.text.toString(),
            phoneTextBox.text.toString(),
            passwordTextBox.text.toString()
        )

        val intent = Intent(this, PreviewActivity::class.java)
        intent.putExtra("User", user)
        startActivity(intent)

    }


}