package com.bambinifashion.home.domain


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PromotionPage(
    @Json(name = "user")
    val user: User
) {
    @JsonClass(generateAdapter = true)
    data class User(
        @Json(name = "proline")
        val proline: Proline
    ) {
        @JsonClass(generateAdapter = true)
        data class Proline(
            @Json(name = "center")
            val center: Center,
            @Json(name = "left")
            val left: String,
            @Json(name = "right")
            val right: String
        ) {
            @JsonClass(generateAdapter = true)
            data class Center(
                @Json(name = "items")
                val items: List<Item>
            ) {
                @JsonClass(generateAdapter = true)
                data class Item(
                    @Json(name = "content")
                    val content: String,
                    @Json(name = "duration")
                    val duration: Int,
                    @Json(name = "highlight")
                    val highlight: Highlight? = null
                ) {

                    @JsonClass(generateAdapter = true)
                    data class Highlight(
                        @Json(name = "backgroundColor")
                        val backgroundColor: String,
                        @Json(name = "periodicity")
                        val periodicity: Int,
                        @Json(name = "textColor")
                        val textColor: String
                    )
                }
            }
        }
    }
}