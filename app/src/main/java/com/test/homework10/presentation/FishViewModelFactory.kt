package com.test.homework10.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.homework10.domain.GetFishListUseCase
import com.test.homework10.domain.InFavouritesUseCase
import com.test.homework10.domain.UpdateFavouritesUseCase
import com.test.homework10.model.FishRepositoryImpl

class FishViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val fishRepository = FishRepositoryImpl(context)
    private val getFishListUseCase = GetFishListUseCase(fishRepository)
    private val updateFavouritesUseCase = UpdateFavouritesUseCase(fishRepository)
    private val inFavouritesUseCase = InFavouritesUseCase(fishRepository)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FishViewModel(
            getFishListUseCase = getFishListUseCase,
            updateFavouritesUseCase = updateFavouritesUseCase,
            inFavouritesUseCase = inFavouritesUseCase
        ) as T
    }
}