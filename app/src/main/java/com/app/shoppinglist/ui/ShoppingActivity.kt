package com.app.shoppinglist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.shoppinglist.R
import com.app.shoppinglist.database.ShoppingDatabase
import com.app.shoppinglist.database.model.ShoppingItem

import com.app.shoppinglist.repository.ShoppingListRepository
import com.app.shoppinglist.viewmodel.ShoppingViewModel
import com.app.shoppinglist.viewmodel.ShoppingViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShoppingActivity : AppCompatActivity() {
    var recycleView: RecyclerView? = null
    var fab: FloatingActionButton? = null
    var layout: LinearLayoutManager? = null
    var adapter: ShoppingAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        recycleView = findViewById(R.id.rvShoppingItems)
        fab = findViewById(R.id.fab)
        layout = LinearLayoutManager(this)

        val database = ShoppingDatabase(this)

        val repository = ShoppingListRepository(database)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[ShoppingViewModel::class.java]
        adapter = ShoppingAdapter(listOf(), viewModel)
        recycleView?.layoutManager = layout
        recycleView?.adapter = adapter

        viewModel.getShoppingItem().observe(this, Observer {

            adapter?.items = it
            adapter?.notifyDataSetChanged()

        })
        fab?.setOnClickListener {
            ShoppingItemDialog(this, object : DialogListner {
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}