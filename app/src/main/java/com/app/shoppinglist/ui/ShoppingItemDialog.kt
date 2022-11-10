package com.app.shoppinglist.ui

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.app.shoppinglist.R
import com.app.shoppinglist.database.model.ShoppingItem

class ShoppingItemDialog(context: Context, var dialogListner: DialogListner) :
    AppCompatDialog(context) {

    var tvName: TextView? = null
    var tvTitle: TextView? = null
    var tvAdd: TextView? = null
    var tvCancel: TextView? = null
    var etName: EditText? = null
    var etAmount: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_shopping_item)
        tvName = findViewById<TextView>(R.id.tvName)
        tvTitle = findViewById<TextView>(R.id.tvTitle)
        tvAdd = findViewById(R.id.tvAdd)
        tvCancel = findViewById<TextView>(R.id.tvCancel)
        etName = findViewById<EditText>(R.id.etName)
        etAmount = findViewById<EditText>(R.id.etAmount)

        tvAdd?.setOnClickListener {
            val name = etName?.text.toString()
            val amount = etAmount?.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please enter name and amount", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            dialogListner.onAddButtonClicked(item)
            dismiss()

        }

        tvCancel?.setOnClickListener {
            cancel()
        }
    }
}