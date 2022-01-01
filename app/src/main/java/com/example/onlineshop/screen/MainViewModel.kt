package com.example.onlineshop.screen

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.onlineshop.api.Api
import com.example.onlineshop.model.BaseResponse
import com.example.onlineshop.model.CategoryModel
import com.example.onlineshop.model.OfferModel
import com.example.onlineshop.model.ProductModel
import com.example.onlineshop.view.CategoryAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel:ViewModel() {

    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://osonsavdo.sd-group.uz/api/")
        .build()
    val api = retrofit.create(Api::class.java)

    val error = MutableLiveData<String>()

    val offersData = MutableLiveData<List<OfferModel>>()
    val categoriesData = MutableLiveData<List<CategoryModel>>()
    val productsData = MutableLiveData<List<ProductModel>>()

    fun getOffers(){
        api.getOffers().enqueue(object : Callback<BaseResponse<List<OfferModel>>> {
            override fun onFailure(call: Call<BaseResponse<List<OfferModel>>>, t: Throwable) {

                error.value = t.localizedMessage
            }

            override fun onResponse(
                call: Call<BaseResponse<List<OfferModel>>>,
                response: Response<BaseResponse<List<OfferModel>>>
            ) {

                if(response.isSuccessful && response.body()!!.success){

                    offersData.value = response.body()!!.data
                }else{
                        error.value = response.body()?.massage?:response.message()
                }
            }


        })
    }
    fun getCategories(){
        api.getCategories().enqueue(object :Callback<BaseResponse<List<CategoryModel>>>{
            override fun onFailure(call: Call<BaseResponse<List<CategoryModel>>>, t: Throwable) {
                error.value = t.localizedMessage
            }

            override fun onResponse(
                call: Call<BaseResponse<List<CategoryModel>>>,
                response: Response<BaseResponse<List<CategoryModel>>>
            ) {
                if(response.isSuccessful && response.body()!!.success){
                    categoriesData.value = response.body()!!.data
                }else{
                    error.value = response.body()?.massage?:response.message()
                }
            }
        })
    }
    fun getTopProducts(){
        api.getTopProducts().enqueue(object :Callback<BaseResponse<List<ProductModel>>>{
            override fun onFailure(call: Call<BaseResponse<List<ProductModel>>>, t: Throwable) {
                error.value = t.localizedMessage
            }

            override fun onResponse(
                call: Call<BaseResponse<List<ProductModel>>>,
                response: Response<BaseResponse<List<ProductModel>>>
            ) {
                if(response.isSuccessful && response.body()!!.success){

                    productsData.value = response.body()!!.data
                }else{
                    error.value = response.body()?.massage?:response.message()
                }
            }
        })
    }

}