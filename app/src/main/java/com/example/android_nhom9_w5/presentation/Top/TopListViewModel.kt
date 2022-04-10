package com.example.android_nhom9_w5.presentation.Top
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_nhom9_w5.data.RestaurantDataStore
import com.example.android_nhom9_w5.model.Restaurant

class TopListViewModel : ViewModel(){

    private val restaurantList = MutableLiveData<List<Restaurant>>()
    val accessedEmail = MutableLiveData<String>()
    fun fetchRestaurantList(): LiveData<List<Restaurant>>{
       val data = RestaurantDataStore.getAllRestaurantListWithFavoriteChecked(accessedEmail.value!!)
        restaurantList.postValue(data)
        return restaurantList
    }

    fun toggleFavoriteRestaurant(restaurant: Restaurant){
        RestaurantDataStore.setFavoriteRestaurantListListener(favoriteRestaurantListListener)
        RestaurantDataStore.toggleFavoriteRestaurantByEmail(accessedEmail.value!!,restaurant)
    }


    private val favoriteRestaurantListListener = object : RestaurantDataStore.FavoriteRestaurantListListener {
        override fun onDataChanged(restaurantList: List<Restaurant>) {
            this@TopListViewModel.restaurantList.postValue(restaurantList)
        }
    }
}