package com.example.android_nhom9_w5.presentation.Signin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_nhom9_w5.data.UserDataStore
import com.example.android_nhom9_w5.model.User

class SignInViewModel : ViewModel() {
    val user = MutableLiveData<User>()
    val isSignInSucceed = MutableLiveData<User>()
    val errorMessage = MutableLiveData<String>()

    init {
        user.value = User()
    }

    fun login(){
        val dataStore = UserDataStore.instance
        dataStore.setLoginCallback(loginCallback)
        dataStore.login(user.value!!.email,user.value!!.password)
    }

    fun clear(){
        isSignInSucceed.value = null
        errorMessage.value = null
    }

    private val loginCallback  = object : UserDataStore.LoginCallback{
        override fun onSucceed(user: User) {
            this@SignInViewModel.isSignInSucceed.value = user
        }

        override fun onFailed(message: String) {
            errorMessage.value = message
        }
    }


}