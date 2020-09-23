package co.paulfran.retrofitpracticeseries.repository

import co.paulfran.retrofitpracticeseries.api.RetrofitInstance
import co.paulfran.retrofitpracticeseries.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
       return RetrofitInstance.api.getPost()
    }
}