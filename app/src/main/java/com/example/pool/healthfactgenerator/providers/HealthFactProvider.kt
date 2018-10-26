package com.example.pool.healthfactgenerator.providers

import com.example.pool.healthfactgenerator.data.remote.models.response.HealthFactResponseModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class HealthFactProvider {

    private val URL = "https://private-4f325-healthboost.apiary-mock.com/"

    private val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    fun getHealthFacts(): Observable<HealthFactResponseModel> {
        return retrofit.create(HealthFactService::class.java)
                .getServerResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable()
    }
}