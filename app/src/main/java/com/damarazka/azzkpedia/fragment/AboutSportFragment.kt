package com.damarazka.azzkpedia.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.damarazka.azzkpedia.NewsViewModel
import com.damarazka.azzkpedia.R
import com.damarazka.azzkpedia.adapter.NewsAdapter
import com.damarazka.azzkpedia.databinding.FragmentAboutDailyBinding
import com.damarazka.azzkpedia.databinding.FragmentAboutSportBinding

class AboutSportFragment : Fragment() {
    private var _binding: FragmentAboutSportBinding? = null
    private val binding get() = _binding as FragmentAboutSportBinding
    private var _viewModel: NewsViewModel? = null
    private val viewModel get() = _viewModel as NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAboutSportBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loadingView.root.visibility = View.VISIBLE
        _viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        viewModel.getSportNews()
        viewModel.sportNews.observe(viewLifecycleOwner) {
            val data = it.articles
            Log.i("SportFragment", "onResponse: $it ")
            binding.rvAboutSport.apply {
                val mAdapter = NewsAdapter()
                mAdapter.setData(data)
                adapter = mAdapter
                layoutManager = LinearLayoutManager(context)
            }
            binding.loadingView.root.visibility = View.GONE
        }
    }
}