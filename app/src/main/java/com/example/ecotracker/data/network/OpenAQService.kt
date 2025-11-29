package com.example.ecotracker.data.network

import com.squareup.moshi.JsonClass
import retrofit2.http.GET
import retrofit2.http.Query

@JsonClass(generateAdapter = true)
data class OpenAQResult(val results: List<OpenAQMeasurement> = emptyList())

@JsonClass(generateAdapter = true)
data class OpenAQMeasurement(val location: String?, val parameter: String?, val value: Double?, val unit: String?, val date: Map<String, Any>?)

interface OpenAQService { @GET("v2/measurements") suspend fun measurements(@Query("city") city: String? = null, @Query("limit") limit: Int = 50): OpenAQResult }
