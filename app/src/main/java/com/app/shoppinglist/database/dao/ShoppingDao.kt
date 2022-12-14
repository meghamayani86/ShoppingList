package com.app.shoppinglist.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.app.shoppinglist.database.model.ShoppingItem


@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * from shopping_items")
    fun getAllShoppingItem(): LiveData<List<ShoppingItem>>

}