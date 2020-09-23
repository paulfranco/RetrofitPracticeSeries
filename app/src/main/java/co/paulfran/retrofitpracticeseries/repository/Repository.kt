package co.paulfran.retrofitpracticeseries.repository

import co.paulfran.retrofitpracticeseries.api.RetrofitInstance
import co.paulfran.retrofitpracticeseries.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
       return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPosts(userId: Int, sort: String, order: String): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost(userId, sort, order)
    }

    suspend fun getCustomPosts2(userId: Int, options: Map<String, String>): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost2(userId, options)
    }
}