package com.damarazka.azzkpedia

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.damarazka.azzkpedia.adapter.NewsAdapter
import com.damarazka.azzkpedia.databinding.ActivityDetailBinding
import com.damarazka.azzkpedia.databinding.ActivitySearchAbleBinding

class SearchAbleActivity : AppCompatActivity() {
    private var _binding: ActivitySearchAbleBinding? = null
    private val binding get() = _binding as ActivitySearchAbleBinding

    private var _searchViewModel: NewsViewModel? = null
    private val searchViewModel get() = _searchViewModel as NewsViewModel
    private var querySearch: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySearchAbleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        _searchViewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        binding.loadingView.root.visibility = View.VISIBLE

        handleIntent(intent)

        searchViewModel.searchNews.observe(this) {
            binding.apply {
                if (it.articles?.size == 0) {
                    tvNoNews.text = getString(R.string.no_news_text)
                    tvNoNews.visibility = View.VISIBLE
                } else {
                    rvSearchResults.apply {
                        val mAdapter = NewsAdapter()
                        mAdapter.setData(it.articles)
                        adapter = mAdapter
                        layoutManager = LinearLayoutManager(this@SearchAbleActivity)
                        visibility = View.VISIBLE
                    }
                }
            }
            binding.loadingView.root.visibility = View.GONE
        }

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        binding.searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        // Verify the action and get the query
        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                querySearch = query
                binding.apply {
                    rvSearchResults.visibility = View.GONE
                    loadingView.root.visibility = View.VISIBLE
                    tvNoNews.visibility = View.INVISIBLE
                    searchView.setQuery("", false)
                    searchView.queryHint = query
                    searchView.clearFocus()
                }
                doMySearch(query)
            }
        }
    }

    private fun doMySearch(query: String) {
        searchViewModel.searchNews(query)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}