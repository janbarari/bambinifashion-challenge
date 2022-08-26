package com.bambinifashion.designsystem.featuredcategory

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bambinifashion.designsystem.databinding.FeaturedCategoryItemBinding
import com.squareup.picasso.Picasso

class FeaturedCategoryVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(category: FeaturedCategory) {
        val binding = FeaturedCategoryItemBinding.bind(itemView)
        binding.title.text = category.title
        Picasso.get().load(category.imageUrl).into(binding.image)
        if (category.backgroundColor != null) {
            binding.root.setBackgroundColor(category.backgroundColor)
        }
    }

}