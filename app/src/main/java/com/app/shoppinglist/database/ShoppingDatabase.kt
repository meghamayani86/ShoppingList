package com.app.shoppinglist.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.shoppinglist.dao.ShoppingDao
import com.app.shoppinglist.model.ShoppingItem


@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDatabase : RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDao

    companion object {

        @Volatile
        private var instance: ShoppingDatabase? = null
    }
}