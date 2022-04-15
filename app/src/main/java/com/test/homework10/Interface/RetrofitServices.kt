package com.test.homework10.Interface

import com.test.homework10.Models.Fish
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET("species")
    fun getMovieList(): Call<MutableList<Fish>>
}