package com.example.ipet

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiIpet {
    @GET("usuarios")
    fun get() : Call<List<Usuario>>

    @GET("ipet")
    fun getPetshop() : Call<List<Petshop>>

    @GET("usuarios/{id}")
    fun get(@Path("id") id:Int) : Call<Usuario>

    @POST("usuarios")
    fun post(@Body novoIpet: Usuario) : Call<Void>

    @POST("usuarios/autenticar")
    fun autenticar(@Body novoIpet: UsuarioLogin) : Call<Void>

    companion object {
        var BASE_URL = "http://34.226.239.106:8080/"
        fun criar() : ApiIpet {
            var retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiIpet::class.java)
        }
    }
}