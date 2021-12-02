package org.sopt.hapdongseminar_29th.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ReviewCreator {
    private const val BASEURL = "https://asia-northeast3-wesopt29-8f39a.cloudfunctions.net/api/"
    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val reviewInterface: ReviewInterface = retrofit.create(ReviewInterface::class.java)
}