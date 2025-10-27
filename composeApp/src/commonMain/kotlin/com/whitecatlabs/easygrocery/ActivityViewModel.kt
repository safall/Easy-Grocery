package com.whitecatlabs.easygrocery

import androidx.lifecycle.ViewModel

data class Category(
    val id: String,
    val title: String,
)

class ActivityViewModel : ViewModel() {
    var selectedCategory: Category = Category("1", "Vegetables")
}