package com.bambinifashion.designsystem.featuredcategory

import java.io.Serializable

data class FeaturedCategory(
    val title: String,
    val imageUrl: String,
    val backgroundColor: Int? = null
): Serializable
