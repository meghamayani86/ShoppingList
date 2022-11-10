package com.app.shoppinglist.ui

import com.app.shoppinglist.database.model.ShoppingItem

interface DialogListner {

    fun onAddButtonClicked(item: ShoppingItem)

}