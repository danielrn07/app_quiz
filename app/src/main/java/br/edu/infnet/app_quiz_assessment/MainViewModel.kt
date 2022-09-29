package br.edu.infnet.app_quiz_assessment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val isLoading: LiveData<Boolean> = _isLoading

    fun setIsLoading(value: Boolean) {
        _isLoading.postValue(value)
    }
}