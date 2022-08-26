package com.bambinifashion.designsystem.quadro

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bambinifashion.designsystem.databinding.QuadroItemBinding
import com.bambinifashion.designsystem.featuredcategory.FeaturedCategoryAdapter
import com.squareup.picasso.Picasso

class QuadroVH(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(quadro: Quadro) {
        val binding = QuadroItemBinding.bind(itemView)
        binding.title.text = quadro.title
        Picasso.get().load(quadro.imageUrl).into(binding.bannerImage)
        val listAdapter = FeaturedCategoryAdapter(quadro.categories)
        binding.list.adapter = listAdapter
    }

}
