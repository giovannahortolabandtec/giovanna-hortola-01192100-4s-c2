package com.example.avaliacaocontinuada02

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListarCachorros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_cachorros)

        val layout: LinearLayout = findViewById(R.id.lista)
        val apiCachorros = ConexaoApiCachorros.criar()

        apiCachorros.get().enqueue(object : Callback<List<Cachorro>> {

            override fun onResponse(
                call: Call<List<Cachorro>>,
                response: Response<List<Cachorro>>
            ) {
                response.body()?.forEach {

                    val tvCachorro = TextView(baseContext)
                    tvCachorro.text = "Id: ${it.id} " +
                            "- Raça: ${it.raca} " +
                            "- Indicadores para crianças: ${it.indicadoCriancas}"
                    tvCachorro.setTextColor(Color.parseColor("#9911AA"))

                    layout.addView(tvCachorro)
                }

            }

            override fun onFailure(call: Call<List<Cachorro>>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na chamada: ${t.message!!}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}