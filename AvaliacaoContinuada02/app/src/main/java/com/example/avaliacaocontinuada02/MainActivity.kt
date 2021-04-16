package com.example.avaliacaocontinuada02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irCadastro(view: View) {
        val cadastro = Intent(this, CadastrarCachorro::class.java)
        startActivity(cadastro)
    }
    fun irLista(view: View) {
        val listados = Intent(this, ListarCachorros::class.java)
        startActivity(listados)
    }
}