package com.app.shoppinglist.repository

import com.app.shoppinglist.database.ShoppingDatabase
import com.app.shoppinglist.database.model.ShoppingItem

class ShoppingListRepository(private val database: ShoppingDatabase) {

    suspend fun upset(item: ShoppingItem) = database.getShoppingDao().upsert(item)
    suspend fun delete(item: ShoppingItem) = database.getShoppingDao().delete(item)

    fun getShoppingList() = database.getShoppingDao().getAllShoppingItem()
}