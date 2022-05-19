package com.example.ipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Cadastro : AppCompatActivity() {
    lateinit var etnome:EditText
    lateinit var etemail:EditText
    lateinit var etsenha:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        etemail = findViewById(R.id.et_email)
        etnome = findViewById(R.id.et_nome)
        etsenha = findViewById(R.id.et_senha)
    }
    fun irTelaLogin(v: View) {
        val telaLogin = Intent(this, Login::class.java)
        startActivity(telaLogin)
    }

    fun cadastrar(v: View) {
        val novoUsuario = Usuario(0, etnome.text.toString(), etemail.text.toString(), etsenha.text.toString())

        val postUsuario = ApiIpet.criar().post(novoUsuario)
        val telaLogin = Intent(this, Login::class.java)

        postUsuario.enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                println("AQUI")
                t.printStackTrace()
                Toast.makeText(baseContext, "Erro na API", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(baseContext, "Usuario Criado!", Toast.LENGTH_SHORT).show()
                    startActivity(telaLogin)
                } else {
                    Toast.makeText(baseContext, "Erro: ${response.errorBody()}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}