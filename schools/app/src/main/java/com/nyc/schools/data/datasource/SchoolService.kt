package com.nyc.schools.data.datasource

import com.nyc.schools.data.models.School
import com.nyc.schools.data.models.SchoolDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolService {
    // https://data.cityofnewyork.us/resource/s3k6-pzi2.json
    // https://data.cityofnewyork.us/resource/f9bf-2cp4.json

    @GET("/resource/s3k6-pzi2.json")
    suspend fun getSchools(): Response<List<School>>

    @GET("/resource/f9bf-2cp4.json")
    suspend fun getSchoolDetail(@Query("dbn") dbn: String): Response<List<SchoolDetail>>
}