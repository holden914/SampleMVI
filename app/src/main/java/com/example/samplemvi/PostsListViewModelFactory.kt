package com.example.samplemvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.samplemvi.repository.JSONPlaceholderRepository

class PostsListViewModelFactory(private val repository: JSONPlaceholderRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostsListViewModel(repository) as T
    }
}