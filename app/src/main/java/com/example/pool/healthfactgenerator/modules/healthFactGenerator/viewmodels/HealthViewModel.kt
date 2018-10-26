package com.example.pool.healthfactgenerator.modules.healthFactGenerator.viewmodels

import com.example.pool.healthfactgenerator.modules.healthFactGenerator.models.HealthFactModel
import com.example.pool.healthfactgenerator.providers.HealthFactProvider
import io.reactivex.Single

class HealthViewModel(private val healthFactProvider: HealthFactProvider) {

        fun getHealthFact(factType: Int): Single<HealthFactModel> {
        return getHealthFacts(factType)
                .map { randomise(it) }
    }

     private fun getHealthFacts(factType: Int): Single<List<HealthFactModel>> {
        return healthFactProvider
                .getHealthFacts()
                .flatMapIterable { it.healthFacts }
                .filter { it.id == factType }
                .toList()
    }

    private fun randomise(healthFacts: List<HealthFactModel>): HealthFactModel {
        return healthFacts[(Math.random() * healthFacts.size).toInt()]
    }
}