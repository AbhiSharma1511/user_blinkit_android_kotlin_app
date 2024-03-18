package com.kotlin.userblinkit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kotlin.userblinkit.databinding.ItemViewProductCategoryBinding
import com.kotlin.userblinkit.models.CategoryModel

class CategoryAdapter(
    private val categoryList : ArrayList<CategoryModel>
): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder((ItemViewProductCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)))
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]
        holder.binding.apply {
            ivCategoryImage.setImageResource(category.image)
            tvCategory.text = category.title
        }
    }

    class CategoryViewHolder(val binding: ItemViewProductCategoryBinding): ViewHolder(binding.root) {

    }
}