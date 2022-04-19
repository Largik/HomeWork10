package com.test.homework10.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.homework10.domain.Fish
import com.test.homework10.domain.GetFishListUseCase
import com.test.homework10.domain.InFavouritesUseCase
import com.test.homework10.domain.UpdateFavouritesUseCase
import kotlinx.coroutines.launch

class FishViewModel(
    private val getFishListUseCase: GetFishListUseCase,
    private val updateFavouritesUseCase: UpdateFavouritesUseCase,
    private val inFavouritesUseCase: InFavouritesUseCase
) : ViewModel(){

    private val _fishList = MutableLiveData<List<Fish>>()
    val fishList: LiveData<List<Fish>> = _fishList

    init{
        getFishList()
    }

    private fun getFishList(){
        viewModelScope.launch {
            try{
                _fishList.value = getFishListUseCase.execute()
            } catch(e: Exception){
                _fishList.value = emptyList()
            }
        }
    }

    fun updateFavorites(fish: Fish){
        updateFavouritesUseCase.execute(fish)
    }

    fun inFavorite(fish: Fish): Boolean{
        return inFavouritesUseCase.execute(fish)
    }
}