package com.test.homework10.domain

class GetFishListUseCase(private val repo: FishRepository) {
    suspend fun execute(): List<Fish>{
        return repo.getFishList()
    }
}