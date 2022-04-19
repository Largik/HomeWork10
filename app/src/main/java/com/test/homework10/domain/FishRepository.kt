package com.test.homework10.domain

interface FishRepository {
    suspend fun getFishList(): List<Fish>
    fun updateFavourites(fish: Fish)
    fun inFavourites(fish: Fish): Boolean
}