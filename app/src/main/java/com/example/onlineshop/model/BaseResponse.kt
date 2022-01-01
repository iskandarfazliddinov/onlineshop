package com.example.onlineshop.model

data class BaseResponse<T>(
    val success:Boolean,
    val data:T,
    val massage:String,
    val error_code:Int
)