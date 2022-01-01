package com.example.onlineshop.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlineshop.R
import com.example.onlineshop.model.CategoryModel
import com.example.onlineshop.model.ProductModel
import kotlinx.android.synthetic.main.category_item_layout.view.*
import kotlinx.android.synthetic.main.product_item_layout.view.*

class ProductAdapter(val items:List<ProductModel>): RecyclerView.Adapter<ProductAdapter.ItemHolder>() {

    class ItemHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_item_layout,parent,false))
    }
    override fun getItemCount(): Int {
        return items.count()
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        Glide.with(holder.itemView.context).load("http://osonsavdo.sd-group.uz/images/${item.image}").into(holder.itemView.imgProduct)
        holder.itemView.tvName.text = item.name
        holder.itemView.tvPrice.text = item.price

    }


}