package org.sopt.hapdongseminar_29th.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL = "https://asia-northeast3-wesopt29-8f39a.cloudfunctions.net/api/"

    private val retrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()

    val categoryService : CategoryService = retrofit.create(CategoryService::class.java)
    val mainVpService : MainViewpagerService=retrofit.create(MainViewpagerService::class.java)

}