package com.tes.sevima.auth.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class OnboardingActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO
        // Buat halaman onboarding
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}