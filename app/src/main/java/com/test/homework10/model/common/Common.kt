package com.test.homework10.model.common

import com.test.homework10.model.retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://www.fishwatch.gov/api/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}