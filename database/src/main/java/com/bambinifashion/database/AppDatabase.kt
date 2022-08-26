package com.bambinifashion.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bambinifashion.database.dao.PageCacheDao
import com.bambinifashion.database.entity.PageCache

@Database(entities = [PageCache::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun pageCacheDao(): PageCacheDao
}