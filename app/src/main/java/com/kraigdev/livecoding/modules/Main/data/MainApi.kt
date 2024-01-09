package com.kraigdev.livecoding.modules.Main.data

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

fun interface MainApi {

    @GET("categories")
    fun getCategories(): Response<MainResponse>
}
