package com.example.market

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemsAdapter (private val mItems: List<Item>) : RecyclerView.Adapter<ItemsAdapter.ViewHolder>()
{

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        var nameTextView: EditText = itemView.findViewById<EditText>(R.id.item_name)
       // println(this.nameTextView)
        var priceTextView: EditText = itemView.findViewById<EditText>(R.id.item_price)
        var urlTextView: EditText = itemView.findViewById<EditText>(R.id.item_URL)

    }

    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_row, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: ItemsAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val item: Item = mItems.get(position)
        // Set item views based on your views and data model
        val nameTextView = viewHolder.nameTextView
        val priceTextView = viewHolder.priceTextView
        val urlTextView = viewHolder.urlTextView
        nameTextView.setText(item.name)
        priceTextView.setText(item.price)
        urlTextView.setText(item.URL)
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return mItems.size
    }
}