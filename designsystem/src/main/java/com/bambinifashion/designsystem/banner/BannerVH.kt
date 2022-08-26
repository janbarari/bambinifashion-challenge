package com.bambinifashion.designsystem.banner

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bambinifashion.designsystem.databinding.BannerItemBinding
import com.squareup.picasso.Picasso

class BannerVH(imageView: View): RecyclerView.ViewHolder(imageView) {

    fun bind(banner: Banner) {
        val binding = BannerItemBinding.bind(itemView)
        Picasso.get().load(banner.imageUrl).into(binding.bannerImage)
    }

}