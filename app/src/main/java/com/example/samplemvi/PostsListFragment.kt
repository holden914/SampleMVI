package com.example.samplemvi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.samplemvi.api.JSONPlaceholderApi
import com.example.samplemvi.api.RetrofitInstance
import com.example.samplemvi.databinding.FragmentPostsListBinding
import com.example.samplemvi.repository.JSONPlaceholderRepository

class PostsListFragment : Fragment(R.layout.fragment_posts_list) {

    // ui
    private lateinit var binding: FragmentPostsListBinding
    private lateinit var postsAdapter: PostsListAdapter
    private lateinit var postsLayoutManager: RecyclerView.LayoutManager
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    // data
    private lateinit var viewModel: PostsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = PostsListViewModelFactory(JSONPlaceholderRepository())
        viewModel = ViewModelProvider(this, factory).get(PostsListViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPostsListBinding.bind(view)
        postsAdapter = PostsListAdapter(mutableListOf())
        postsLayoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        with(binding.postsRecyclerView) {
            this.adapter = postsAdapter
            this.layoutManager = postsLayoutManager
        }

        swipeRefreshLayout = binding.swipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener {
            viewModel.requestPosts()
        }

        viewModel.postsList.observe(viewLifecycleOwner, {
            postsAdapter.updatePosts(it)
            binding.postsRecyclerView.scheduleLayoutAnimation()
        })

        viewModel.isRequesting.observe(viewLifecycleOwner, {
            swipeRefreshLayout.isRefreshing = it
        })
    }

    companion object {
        private const val TAG = "PostsListFragment"
    }
}