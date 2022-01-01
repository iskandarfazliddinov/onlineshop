package com.example.onlineshop.api


import com.example.onlineshop.model.BaseResponse
import com.example.onlineshop.model.CategoryModel
import com.example.onlineshop.model.OfferModel
import com.example.onlineshop.model.ProductModel
import retrofit2.http.GET
import retrofit2.Call

interface Api {
    @GET("get_offers")
    fun getOffers():Call<BaseResponse<List<OfferModel>>>

    @GET("get_categories")
    fun getCategories(): Call<BaseResponse<List<CategoryModel>>>

    @GET("get_top_products")
    fun getTopProducts():Call<BaseResponse<List<ProductModel>>>

}