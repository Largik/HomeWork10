package com.test.homework10.model

import android.content.Context
import com.test.homework10.domain.Fish
import com.test.homework10.domain.FishRepository
import com.test.homework10.model.common.Common

class FishRepositoryImpl(context: Context) : FishRepository {
    private val sharedPreferences =
        context.getSharedPreferences("favourite_id", Context.MODE_PRIVATE)

    override suspend fun getFishList(): List<Fish> {
        return Common.retrofitService.getFishListAsync().await().map {
            it.toFish()
        }
    }

    override fun updateFavourites(fish: Fish) {
        if (inFavourites(fish)) {
            sharedPreferences.edit().remove(fish.speciesName).apply()
        } else {
            sharedPreferences.edit().putBoolean(fish.speciesName, true).apply()
        }
    }

    override fun inFavourites(fish: Fish): Boolean {
        return sharedPreferences.getBoolean(fish.speciesName, false)
    }
}