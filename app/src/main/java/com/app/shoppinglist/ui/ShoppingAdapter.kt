package com.app.shoppinglist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.shoppinglist.R
import com.app.shoppinglist.database.model.ShoppingItem
import com.app.shoppinglist.viewmodel.ShoppingViewModel

class ShoppingAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.tvName.text = curShoppingItem.name
        holder.tvAmount.text = "${curShoppingItem.amount}"

        holder.ivDelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        holder.ivPlus.setOnClickListener {
            curShoppingItem.amount + 1
            viewModel.upsert(curShoppingItem)
        }

        holder.ivMinus.setOnClickListener {
            if (curShoppingItem.amount > 0) {
                curShoppingItem.amount--

                viewModel.upsert(curShoppingItem)
            }
        }
    }


    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView
        val tvAmount: TextView
        val ivDelete: ImageView
        val ivPlus: ImageView
        val ivMinus: ImageView

        init {
            tvName = itemView.findViewById(R.id.tvName)
            tvAmount = itemView.findViewById(R.id.tvAmount)
            ivDelete = itemView.findViewById(R.id.ivDelete)
            ivPlus = itemView.findViewById(R.id.ivPlus)
            ivMinus = itemView.findViewById(R.id.ivMinus)


        }


    }
}




