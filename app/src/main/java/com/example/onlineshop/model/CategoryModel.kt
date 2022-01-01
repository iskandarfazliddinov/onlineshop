package com.example.onlineshop.model

data class CategoryModel(
    val id :Int,
    val title : String,
    val icon : String,
    var chacked:Boolean=false
)