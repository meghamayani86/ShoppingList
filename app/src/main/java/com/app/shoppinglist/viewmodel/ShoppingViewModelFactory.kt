package com.app.shoppinglist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.shoppinglist.repository.ShoppingListRepository

class ShoppingViewModelFactory(private val repository: ShoppingListRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }

}