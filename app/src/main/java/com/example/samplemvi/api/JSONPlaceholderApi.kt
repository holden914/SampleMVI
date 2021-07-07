package com.example.samplemvi.api

import com.example.samplemvi.model.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface JSONPlaceholderApi {

    @GET("posts")
    fun  getPosts(): List<Post>

    @GET("post/{id}")
    fun getPost(@Path("id") id: Int): Post

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
}