package com.nyc.schools.data.repository

import com.nyc.schools.data.datasource.SchoolDataSourceService
import com.nyc.schools.viewmodels.DetailViewModel
import com.nyc.schools.viewmodels.SchoolsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository which gets data from the network layer.
 */
class SchoolRepository {

    /**
     * Method for fetching schools.
     */
    suspend fun getSchools(): SchoolsViewModel.SchoolState {
        return withContext(Dispatchers.IO) {
            val schools = SchoolDataSourceService.getRetrofitService().getSchools()
            if (schools.isSuccessful)
                SchoolsViewModel.SchoolState.Success(schools.body()!!)
            else
                SchoolsViewModel.SchoolState.Failure
        }
    }

    /**
     * Method for fetching school detail.
     */
    suspend fun getSchoolDetail(dbn: String): DetailViewModel.SchoolDetailState {
        return withContext(Dispatchers.IO) {
            val schools = SchoolDataSourceService.getRetrofitService().getSchoolDetail(dbn)
            if (schools.isSuccessful)
                DetailViewModel.SchoolDetailState.Success(schools.body()!!)
            else
                DetailViewModel.SchoolDetailState.Failure
        }
    }
}