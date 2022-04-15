package com.test.homework10.Common

import com.test.homework10.Interface.RetrofitServices
import com.test.homework10.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://www.fishwatch.gov/api/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}