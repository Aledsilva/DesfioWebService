package com.example.choreimaspassobem.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.choreimaspassobem.R

class ActLogin : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var enter: Button

    private val onClickEnter = View.OnClickListener { view ->
        if (loginValidation(name, email, password)) {
            Toast.makeText(view.context, "Bem-vindo " + name.text.toString() + "!!", Toast.LENGTH_LONG).show()
            startActivity(Intent(view.context, ActMain::class.java))
        } else {
            Toast.makeText(view.context, "Por favor, preencha todos os campos!", Toast.LENGTH_LONG).show()
        }
    }

    private fun loginValidation(vararg listTextLogin: EditText): Boolean{
        listTextLogin.forEach { if(it.text.toString().isEmpty()) return false }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_login)
        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        enter = findViewById(R.id.button_enter)
        enter.setOnClickListener(onClickEnter)
    }
}