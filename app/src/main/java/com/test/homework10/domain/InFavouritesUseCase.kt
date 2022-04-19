package com.test.homework10.domain

class InFavouritesUseCase(private val repo: FishRepository) {
    fun execute(fish: Fish): Boolean{
        return repo.inFavourites(fish)
    }
}