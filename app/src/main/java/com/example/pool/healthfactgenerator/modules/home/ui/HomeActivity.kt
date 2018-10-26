package com.example.pool.healthfactgenerator.modules.home.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pool.healthfactgenerator.R
import com.example.pool.healthfactgenerator.modules.healthFactGenerator.ui.HealthFactActivity
import com.example.pool.healthfactgenerator.modules.home.viewModels.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onCtaClick()
    }

    private fun onCtaClick() {
        physicalHealthCta.setOnClickListener { startActivity(1) }
        mentalHealthCta.setOnClickListener { startActivity(2) }
    }

    private fun startActivity(int: Int) {
        val intent = Intent(this, HealthFactActivity::class.java)
        intent.putExtra("Health Type", int)
        startActivity(intent)
    }
}
