package com.bambinifashion.home.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bambinifashion.designsystem.Item
import com.bambinifashion.designsystem.banner.Banner
import com.bambinifashion.designsystem.banner.BannerVH
import com.bambinifashion.designsystem.featuredcategory.FeaturedCategories
import com.bambinifashion.designsystem.featuredcategory.FeaturedCategoriesVH
import com.bambinifashion.designsystem.quadro.Quadro
import com.bambinifashion.designsystem.quadro.QuadroVH
import com.bambinifashion.home.R

class HomeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: MutableList<Item> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> {
                BannerVH(
                    LayoutInflater.from(parent.context).inflate(R.layout.banner_item, parent, false)
                )
            }
            2 -> {
                FeaturedCategoriesVH(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.featured_categories_item, parent, false)
                )
            }
            3 -> {
                QuadroVH(
                    LayoutInflater.from(parent.context).inflate(R.layout.quadro_item, parent, false)
                )
            }
            else -> EmptyViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.empty_item, parent, false)
            )
        }
    }

    inner class EmptyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemCount(): Int {
        return data.size
    }

    fun updateList(newData: List<Item>) {
        val diffCallback = HomeDiffCallback(data, newData)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        data.clear()
        data.addAll(newData)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemViewType(position: Int): Int {
        for (itemModel in data) {
            if (data[position]::class.java == Banner::class.java) {
                return 1
            }
            if (data[position]::class.java == FeaturedCategories::class.java) {
                return 2
            }
            if (data[position]::class.java == Quadro::class.java) {
                return 3
            }
        }
        return -1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is BannerVH) {
            holder.bind(data[position] as Banner)
        }
        if (holder is FeaturedCategoriesVH) {
            holder.bind(data[position] as FeaturedCategories)
        }
        if (holder is QuadroVH) {
            holder.bind(data[position] as Quadro)
        }
    }

}