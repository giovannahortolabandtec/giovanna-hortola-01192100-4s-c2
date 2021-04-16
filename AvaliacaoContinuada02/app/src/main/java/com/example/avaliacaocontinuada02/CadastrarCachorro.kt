package com.example.avaliacaocontinuada02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastrarCachorro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_cachorro)
    }

    fun cadastrarCachorro(view: View) {
        val apiCachorros = ConexaoApiCachorros.criar()

        val etRaca: TextView = findViewById(R.id.et_raca)
        val etPreco: TextView = findViewById(R.id.et_preco)
        val swCheck: Switch = findViewById(R.id.sw_indicacao)

        val raca = etRaca.text.toString()
        val precoMedio = etPreco.text.toString().toInt()
        val indicadoCriancas = swCheck.text.toString().toBoolean()

        val novoCachorro = Cachorro(0, raca, precoMedio, indicadoCriancas)

        val resultado: TextView = findViewById(R.id.tv_resultado)

        apiCachorros.post(novoCachorro).enqueue(object : Callback<Cachorro> {
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                if(response.code() == 201){
                    val cachorroCriado = response.body()
                    resultado.text = "Cão cadastrado com sucesso"
                } else {
                    resultado.text = "Falha ao criar o cachorro: ${response.errorBody()!!}"
                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na chamada: ${t.message!!}", Toast.LENGTH_SHORT)
                    .show()
            }
        })


    }
}