package com.bambinifashion.designsystem.banner

import com.bambinifashion.designsystem.Item

data class Banner(
    override val id: Int,
    val imageUrl: String
): Item(id)
