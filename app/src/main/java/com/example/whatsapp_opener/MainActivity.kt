package com.example.whatsapp_opener

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.whatsapp_opener.R.id.editTextTextPersonName as editTextTextPersonName1

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        supportActionBar?.hide()
        var editText = findViewById<EditText>(editTextTextPersonName1)
    }

    fun openwhatsapp(view: View) {
        val Valve = editText.text.toString()
        whatsAppoper(Valve)
    }

    fun whatsAppoper(number:String) {
        val intent = Intent(Intent.ACTION_VIEW)
         intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$number")
         startActivity(intent)
    }
}