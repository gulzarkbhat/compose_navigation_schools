package com.nyc.schools.data.datasource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit Service for backend processing.
 */
object SchoolDataSourceService {

    private val BASE_URL = "https://data.cityofnewyork.us"

    fun getRetrofitService(): SchoolService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SchoolService::class.java)
    }
}