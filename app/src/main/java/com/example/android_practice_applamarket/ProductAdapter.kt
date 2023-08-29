package com.example.android_practice_applamarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice_applamarket.data.Product
import com.example.android_practice_applamarket.databinding.ItemProductBinding

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

    private val list = mutableListOf<Product>()

    fun addItems(items: List<Product>) {
        list.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        return ViewHolder(
            ItemProductBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Product) = with(binding) {
            itemName.text = item.name
            itemLocation.text = item.location
            itemPrice.text = item.price.toString()
            itemImage.setImageResource(item.source)
            itemReplyNum.text = item.reply.toString()
            itemHeartNum.text = item.like.toString()
            itemImage.clipToOutline = true
        }
    }
}
