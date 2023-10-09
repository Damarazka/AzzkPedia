package com.damarazka.azzkpedia

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.damarazka.azzkpedia.adapter.SectionPagerAdapter
import com.damarazka.azzkpedia.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

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
        val ListFragment = arrayOf("Common", "Daily", "Sport", "Warning")

        // set TabLayout and vp2
        TabLayoutMediator(binding.tadLayouts, binding.vpContainer) { tab, position ->
            tab.text = ListFragment[position]
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val searchView = menu?.findItem(R.id.option_search)?.actionView as SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when(item.itemId){
//            R.id.option_search -> onSearchRequested()
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}