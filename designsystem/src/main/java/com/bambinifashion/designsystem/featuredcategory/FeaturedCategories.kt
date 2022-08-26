package com.bambinifashion.designsystem.featuredcategory

import com.bambinifashion.designsystem.Item

data class FeaturedCategories(
    override val id: Int,
    val categories: List<FeaturedCategory>
): Item(id)