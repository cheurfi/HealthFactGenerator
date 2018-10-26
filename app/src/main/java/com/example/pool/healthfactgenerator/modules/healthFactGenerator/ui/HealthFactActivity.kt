package com.example.pool.healthfactgenerator.modules.healthFactGenerator.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.pool.healthfactgenerator.R
import com.example.pool.healthfactgenerator.modules.healthFactGenerator.viewmodels.HealthViewModel
import com.example.pool.healthfactgenerator.providers.HealthFactProvider
import kotlinx.android.synthetic.main.activity_health_fact_item.*

class HealthFactActivity : AppCompatActivity() {

    private val healthFactProvider = HealthFactProvider()
    private val mentalHealthViewModel = HealthViewModel(healthFactProvider)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_fact_item)

        val bundle: Bundle? = intent.extras

        bundle?.let {
            bundle.apply {
                val id = getInt("healthType")
                mentalHealthViewModel.getHealthFact(id)
                        .subscribe({ data -> displayFact(data.title, data.healthfact) },
                                Throwable::printStackTrace)
            }
        }
    }

    private fun displayFact(title: String, fact: String) {
        healthFactTitle.text = title
        healthFactDescription.text = fact
    }
}