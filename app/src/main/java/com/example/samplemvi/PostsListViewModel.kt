package com.example.samplemvi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplemvi.model.Post
import com.example.samplemvi.repository.JSONPlaceholderRepository
import kotlinx.coroutines.launch

class PostsListViewModel(private val repository: JSONPlaceholderRepository) : ViewModel() {

    private val _postsList = MutableLiveData<List<Post>>()
    val postsList: LiveData<List<Post>>
        get() {
           return _postsList
        }

    private val _isRequesting = MutableLiveData<Boolean>()
    val isRequesting: LiveData<Boolean>
        get() {
            return _isRequesting
        }

    init {
        requestPosts()
    }

    fun requestPosts() {
        _isRequesting.value = true
        viewModelScope.launch {
            _postsList.value = repository.getPosts()
        }
        _isRequesting.value = false
    }

    companion object {
        private const val TAG = "PostsListViewModel"
    }
}