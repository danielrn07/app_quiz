package br.edu.infnet.app_quiz_assessment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _isCheck: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val isCheck: LiveData<Boolean> = _isCheck

    fun setIsCheck(value: Boolean) {
        _isCheck.postValue(value)
    }
}