package com.app.shoppinglist.viewmodel

import androidx.lifecycle.ViewModel
import com.app.shoppinglist.database.ShoppingDatabase
import com.app.shoppinglist.database.model.ShoppingItem
import com.app.shoppinglist.repository.ShoppingListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingListRepository) : ViewModel() {


    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upset(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun  getShoppingItem() = repository.getShoppingList()
}