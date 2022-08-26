package com.bambinifashion.home.data

import com.bambinifashion.database.AppDatabase
import com.bambinifashion.database.entity.PageCache
import com.bambinifashion.home.data.remote.*
import com.bambinifashion.home.domain.*
import com.squareup.moshi.Moshi

class HomeRepositoryImpl(
    private val api: HomeApiService,
    private val db: AppDatabase,
    private val moshi: Moshi
) : HomeRepository {

    companion object {
        const val LANDING_PAGE_KEY = "landing"
        const val PROMOTIONS_PAGE_KEY = "promotion"
    }

    override suspend fun getLanding(): LandingPage? {
        val content: String? = try {
            LandingPageJsonAdapter(moshi).lenient().toJson(api.getLanding())
        } catch (e: Throwable) {
            null
        }
        if (content != null) {
            db.pageCacheDao().upsert(
                PageCache(
                    key = LANDING_PAGE_KEY,
                    content = content,
                    createdAt = System.currentTimeMillis()
                )
            )
        }
        var result: LandingPage? = null
        db.pageCacheDao().get(LANDING_PAGE_KEY).let {
            if(it.isNotEmpty()) {
                result = LandingPageJsonAdapter(moshi).lenient().fromJson(it.first().content)
            }
        }

        return result
    }

    override suspend fun getPromotions(): PromotionPage? {
        val content: String? = try {
            PromotionPageJsonAdapter(moshi).lenient().toJson(api.getPromotions())
        } catch (e: Throwable) {
            null
        }
        if (content != null) {
            db.pageCacheDao().upsert(
                PageCache(
                    key = PROMOTIONS_PAGE_KEY,
                    content = content,
                    createdAt = System.currentTimeMillis()
                )
            )
        }
        var result: PromotionPage? = null
        db.pageCacheDao().get(PROMOTIONS_PAGE_KEY).let {
            if(it.isNotEmpty()) {
                result = PromotionPageJsonAdapter(moshi).lenient().fromJson(it.first().content)
            }
        }
        return result
    }

}
