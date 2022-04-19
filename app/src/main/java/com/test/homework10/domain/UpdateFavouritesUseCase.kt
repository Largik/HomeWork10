package com.test.homework10.domain

class UpdateFavouritesUseCase(private val repo: FishRepository) {
    fun execute(fish: Fish){
        return repo.updateFavourites(fish)
    }
}