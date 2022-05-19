package com.example.ipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun irTelaCadastro(v: View) {
        val telaCadastro = Intent(this, Cadastro::class.java)
        startActivity(telaCadastro)
    }
    fun irTelaLogin(v: View) {
        val telaLogin = Intent(this, Login::class.java)
        startActivity(telaLogin)
    }
}