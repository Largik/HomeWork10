package com.test.homework10.model.common

import com.test.homework10.model.dto.FishJsonResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface RetrofitServices {
    @GET("species")
    fun getFishListAsync(): Deferred<List<FishJsonResponse>>
}