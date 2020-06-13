package com.example.choreimaspassobem.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.choreimaspassobem.R
import com.example.choreimaspassobem.adapter.MainAdapter
import com.example.choreimaspassobem.model.Results
import com.example.choreimaspassobem.util.viewModel
import com.example.choreimaspassobem.viewmodel.ViewModelMarvel

class ActMain : AppCompatActivity() {

    private val viewModelMarvel by lazy { viewModel<ViewModelMarvel>() }
    private var results = mutableSetOf<Results>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_recycler)

        val recycler = findViewById<RecyclerView>(R.id.recycler_view_main)

        val adapterComics = MainAdapter(results)
        recycler.adapter = adapterComics
        val layoutManager = GridLayoutManager(this, 3)
        recycler.layoutManager = layoutManager

        viewModelMarvel.getAllComics()
        viewModelMarvel.listMutableComic.observe(this, Observer {
            it?.let { itChar -> results.addAll(itChar) }
            adapterComics.notifyDataSetChanged()
        })
    }
}