package com.example.market


class Item(val name: String, val price: String, val URL: String) {
    companion object {
        private var lastItemId = 0
        fun createEmptyItemList(): ArrayList<Item> {
            return createItemList(1)
        }

        fun createItemList(numContacts: Int): ArrayList<Item> {
            val items = ArrayList<Item>()
            for (i in 1..numContacts) {
                items.add(Item("", "", ""))
            }
            return items
        }

        fun createItemListWithEmptyItem(items: ArrayList<Item>): ArrayList<Item> {
            items.add(Item("", "", ""))
            return items
        }
    }
}