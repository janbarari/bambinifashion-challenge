package com.bambinifashion.designsystem.featuredcategory

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bambinifashion.designsystem.databinding.FeaturedCategoriesItemBinding

class FeaturedCategoriesVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(featuredCategories: FeaturedCategories) {
        val binding = FeaturedCategoriesItemBinding.bind(itemView)
        val listAdapter = FeaturedCategoryAdapter(featuredCategories.categories)
        binding.list.adapter = listAdapter
    }

}