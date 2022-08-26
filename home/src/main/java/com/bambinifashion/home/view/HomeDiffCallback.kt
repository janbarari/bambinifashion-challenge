package com.bambinifashion.home.view

import androidx.recyclerview.widget.DiffUtil
import com.bambinifashion.designsystem.Item

class HomeDiffCallback(
    private val oldFeeds: List<Item>,
    private val newFeeds: List<Item>
): DiffUtil.Callback() {


    override fun getOldListSize(): Int {
        return oldFeeds.size
    }

    override fun getNewListSize(): Int {
        return newFeeds.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldFeeds[oldItemPosition].id == newFeeds[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldFeeds[oldItemPosition].id == newFeeds[newItemPosition].id
    }
}
