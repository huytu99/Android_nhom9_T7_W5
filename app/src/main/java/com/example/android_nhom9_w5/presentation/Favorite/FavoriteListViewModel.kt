package com.example.android_nhom9_w5.presentation.Favorite

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_nhom9_w5.data.RestaurantDataStore
import com.example.android_nhom9_w5.model.Restaurant

class FavoriteListViewModel : ViewModel(){
    val accessedEmail = MutableLiveData<String>()
    private val restaurantList = MutableLiveData<List<Restaurant>>()

    fun fetchRestaurantList(): LiveData<List<Restaurant>>{
        Log.d("FavoriteLs","email=${accessedEmail.value}")
        val data =  RestaurantDataStore.getFavoriteRestaurantList(accessedEmail.value!!).toMutableList()
        restaurantList.postValue(data)
        return restaurantList

    }
}