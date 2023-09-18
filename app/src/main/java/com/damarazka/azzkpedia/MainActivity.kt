package com.damarazka.azzkpedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.ListFragment
import com.damarazka.azzkpedia.adapter.SectionPagerAdapter
import com.damarazka.azzkpedia.data.NewsResponse
import com.damarazka.azzkpedia.data.network.ApiClient
import com.damarazka.azzkpedia.databinding.ActivityMainBinding
import com.damarazka.azzkpedia.fragment.CommonFragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolBar)
        setContentView(binding.root)

        // set adapter vp2 using SectionPagerAdapter class
        binding.vpContainer.adapter = SectionPagerAdapter(this)
        // array untuk set title tad item in TabLayout
        val ListFragment  = arrayOf("Common","Daily","Sport","Warning")

        // set TabLayout and vp2
        TabLayoutMediator(binding.tadLayouts, binding.vpContainer){ tab, position ->
            tab.text = ListFragment[position]
        }.attach()
    }
}