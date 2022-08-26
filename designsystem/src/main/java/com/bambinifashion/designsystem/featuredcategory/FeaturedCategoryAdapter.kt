package com.bambinifashion.designsystem.featuredcategory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bambinifashion.designsystem.R

class FeaturedCategoryAdapter(private val data: List<FeaturedCategory>) :
    RecyclerView.Adapter<FeaturedCategoryVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedCategoryVH {
        return FeaturedCategoryVH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.featured_category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FeaturedCategoryVH, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}