package com.example.android_practice_applamarket

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice_applamarket.data.Product
import com.example.android_practice_applamarket.databinding.ItemProductBinding
import java.text.DecimalFormat

class ProductAdapter(private val itemClickListener: ViewHolder.OnItemClickListener,
private val itemLongClickListener: ViewHolder.OnItemLongClickListener,
private val list: MutableList<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

//    private val list = mutableListOf<Product>()
//
//    fun addItems(items: List<Product>) {
//        list.addAll(items)
//    }

//    fun removeItem(position:Int) {
//        list.removeAt(position)
//        notifyItemRemoved(position)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        return ViewHolder(
            ItemProductBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(item)
        }
        holder.itemView.setOnLongClickListener {
            itemLongClickListener.onItemLongClick(item, position)
            return@setOnLongClickListener(true)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

        interface OnItemClickListener {
            fun onItemClick(product: Product)
        }

        interface OnItemLongClickListener {
            fun onItemLongClick(product: Product, position: Int)
        }

        private val decimalFormat = DecimalFormat("#,###")
        @SuppressLint("SetTextI18n")
        fun bind(item : Product) = with(binding) {
            itemName.text = item.productName
            itemLocation.text = item.location
            itemPrice.text = decimalFormat.format(item.price) + "원"
            itemImage.setImageResource(item.imageResource)
            itemReplyNum.text = item.chatting.toString()
            itemHeartNum.text = item.like.toString()
            itemImage.clipToOutline = true
        }
    }
}

