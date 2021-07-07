package com.example.samplemvi.repository

import com.example.samplemvi.api.RetrofitInstance
import com.example.samplemvi.model.Post

class JSONPlaceholderRepository {

    suspend fun getPost(id: Int): Post {
        return RetrofitInstance.jsonPlaceholderApi.getPost(id)
    }

    suspend fun getPosts(): List<Post> {
        return RetrofitInstance.jsonPlaceholderApi.getPosts()
    }
}