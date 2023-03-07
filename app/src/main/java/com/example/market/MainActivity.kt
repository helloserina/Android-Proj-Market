package com.example.market

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var items: ArrayList<Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        // ...
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        // Lookup the recyclerview in activity layout
        val rvItems = findViewById<View>(R.id.itemsRecyclerView) as RecyclerView
        // Initialize contacts
        items = Item.createEmptyItemList()
        // Create adapter passing in the sample user data
        val adapter = ItemsAdapter(items)
        // Attach the adapter to the recyclerview to populate items
        rvItems.adapter = adapter
        // Set layout manager to position the items
        rvItems.layoutManager = LinearLayoutManager(this)

        // add listener for add item
        val addButton = findViewById<Button>(R.id.addItemButton)
        addButton.setOnClickListener(View.OnClickListener() {
            items = Item.createItemListWithEmptyItem(items)
            rvItems.adapter = ItemsAdapter(items)
            rvItems.layoutManager = LinearLayoutManager(this)
            return@OnClickListener
        })

        //setListeners(rvItems.findViewById<LinearLayout>(R.id.layout).findViewById(R.id.item_name))
    }

    private fun setListeners(itemView: EditText) {
        itemView.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val text = v.text.toString()
                print("HELLOSERINA ")
                findViewById<EditText>(itemView.id).isEnabled = false
                /*
                if (itemView.id.equals(R.id.item_name)) {

                }

                    if (itemView.id.equals(R.id.item_name)) {
                        findViewById<EditText>(R.id.item_name).isEnabled = false
                    } else if (itemView.id.equals(R.id.item_price)) {
                        findViewById<EditText>(R.id.item_price).isEnabled = false
                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            "All guesses completed!",
                            Toast.LENGTH_SHORT
                        ).show()
                        Toast.makeText(
                            this@MainActivity,
                            "The answer was $answer",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "4-character guesses only!",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                 */
                return@OnEditorActionListener true
            }
            false
        })
    }
}