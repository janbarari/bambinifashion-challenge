package com.bambinifashion.designsystem.quadro

import com.bambinifashion.designsystem.Item
import com.bambinifashion.designsystem.featuredcategory.FeaturedCategory

data class Quadro(
    override val id: Int,
    val title: String,
    val imageUrl: String,
    val categories: List<FeaturedCategory>
): Item(id)