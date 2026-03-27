package com.abidnabil.regifrom

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PreviewActivity : AppCompatActivity() {
    private lateinit var user: User
    private lateinit var fullNameField: TextView
    private lateinit var titleField: TextView
    private lateinit var emailField: TextView
    private lateinit var phoneNumberField: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        getViews()
        user = intent.getSerializableExtra("User") as User
        displayDetails(user)
        emailField.setOnClickListener {
            intent= Intent(Intent.ACTION_SENDTO ).apply {
                data= "mailto:${user.email}".toUri()
            }
            startActivity(intent)
        }
        phoneNumberField.setOnClickListener {
            intent= Intent(Intent.ACTION_SENDTO ).apply {
                data= "smsto:${user.phone}".toUri()
            }
            startActivity(intent)
        }


    }

    private fun getViews() {
        fullNameField = findViewById(R.id.text_view_full_name)
        titleField = findViewById(R.id.text_view_job_title)
        emailField = findViewById(R.id.text_view_result_email)
        phoneNumberField = findViewById(R.id.text_view_result_phone)
    }

    private fun displayDetails(user: User) {
        fullNameField.text = user.fullName
        titleField.text = user.jobTitle
        emailField.text = user.email
        phoneNumberField.text = user.phone

    }
}