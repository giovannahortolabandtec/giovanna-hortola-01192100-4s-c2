package com.example.avaliacaocontinuada02

import retrofit2.Call
import retrofit2.http.*

interface ApiCachorros {
    @GET("cachorros")
    fun get(): Call<List<Cachorro>>

    @GET("cachorros/{id}") //
    fun get(@Path("id") id:Int): Call<Cachorro>

    @DELETE("cachorros/{id}")
    fun delete(@Path("id") id:Int): Call<Void>

    @POST("cachorros")
    fun post(@Body novoCachorro:Cachorro): Call<Cachorro>

}