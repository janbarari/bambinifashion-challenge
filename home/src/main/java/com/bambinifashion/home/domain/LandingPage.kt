package com.bambinifashion.home.domain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LandingPage(
    @Json(name = "page")
    val page: Page
) {
    @JsonClass(generateAdapter = true)
    data class Page(
        @Json(name = "content")
        val content: List<Content>,
        @Json(name = "meta")
        val meta: Meta
    ) {
        @JsonClass(generateAdapter = true)
        data class Content(
            @Json(name = "data")
            val `data`: Data,
            @Json(name = "name")
            val name: String
        ) {
            @JsonClass(generateAdapter = true)
            data class Data(
                @Json(name = "caption")
                val caption: Caption? = null,
                @Json(name = "categories")
                val categories: List<Category>? = null,
                @Json(name = "image")
                val image: Image? = null,
                @Json(name = "isMainImageRight")
                val isMainImageRight: Boolean? = null,
                @Json(name = "linkUrl")
                val linkUrl: String? = null,
                @Json(name = "size")
                val size: String? = null,
                @Json(name = "title")
                val title: String? = null,
                @Json(name = "video")
                val video: Video? = null
            ) {
                @JsonClass(generateAdapter = true)
                data class Caption(
                    @Json(name = "cta")
                    val cta: Cta,
                    @Json(name = "description")
                    val description: String?,
                    @Json(name = "heading")
                    val heading: Heading,
                    @Json(name = "isInverted")
                    val isInverted: Boolean,
                    @Json(name = "position")
                    val position: Position
                ) {
                    @JsonClass(generateAdapter = true)
                    data class Cta(
                        @Json(name = "backgroundColor")
                        val backgroundColor: String,
                        @Json(name = "text")
                        val text: String?,
                        @Json(name = "textColor")
                        val textColor: String
                    )

                    @JsonClass(generateAdapter = true)
                    data class Heading(
                        @Json(name = "isHidden")
                        val isHidden: Boolean,
                        @Json(name = "text")
                        val text: String
                    )

                    @JsonClass(generateAdapter = true)
                    data class Position(
                        @Json(name = "x")
                        val x: String,
                        @Json(name = "y")
                        val y: String
                    )
                }

                @JsonClass(generateAdapter = true)
                data class Category(
                    @Json(name = "backgroundColor")
                    val backgroundColor: String?=null,
                    @Json(name = "image")
                    val image: Image,
                    @Json(name = "linkUrl")
                    val linkUrl: String,
                    @Json(name = "title")
                    val title: String
                ) {
                    @JsonClass(generateAdapter = true)
                    data class Image(
                        @Json(name = "src")
                        val src: String
                    )
                }

                @JsonClass(generateAdapter = true)
                data class Image(
                    @Json(name = "src")
                    val src: String
                )

                @JsonClass(generateAdapter = true)
                data class Video(
                    @Json(name = "src")
                    val src: String? = null
                )
            }
        }

        @JsonClass(generateAdapter = true)
        data class Meta(
            @Json(name = "canonicalUrl")
            val canonicalUrl: String?,
            @Json(name = "content")
            val content: String?,
            @Json(name = "description")
            val description: String?,
            @Json(name = "title")
            val title: String?
        )
    }
}