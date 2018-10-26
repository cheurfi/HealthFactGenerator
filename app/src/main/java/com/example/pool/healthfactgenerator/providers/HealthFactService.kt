package com.example.pool.healthfactgenerator.providers

import com.example.pool.healthfactgenerator.data.remote.models.response.HealthFactResponseModel
import io.reactivex.Single
import retrofit2.http.GET

interface HealthFactService {

    @GET("facts")
    fun getServerResponse(): Single<HealthFactResponseModel>
}