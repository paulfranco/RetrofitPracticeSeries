package co.paulfran.retrofitpracticeseries

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.paulfran.retrofitpracticeseries.model.Post
import co.paulfran.retrofitpracticeseries.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    fun getPost() {
        viewModelScope.launch {
            val response= repository.getPost()
            myResponse.value = response
        }
    }
}