package com.bambinifashion.database.dao

import androidx.room.*
import com.bambinifashion.database.entity.PageCache

@Dao
interface PageCacheDao {

    @Query("SELECT * FROM pagecache WHERE `key` = :key")
    suspend fun get(key: String): List<PageCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(pageCache: PageCache)

    @Query("DELETE FROM pagecache")
    suspend fun deleteAll()

    @Query("DELETE FROM pagecache WHERE `key` = :key")
    suspend fun delete(key: String)

}
