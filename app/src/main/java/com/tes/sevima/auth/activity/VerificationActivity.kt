package com.tes.sevima.auth.activity

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import com.tes.sevima.R
import com.tes.sevima.base.BaseActivity
import com.tes.sevima.home.HomeActivity
import kotlinx.android.synthetic.main.activity_verification.*

class VerificationActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_verification)
        this.setup()
    }

    fun setup () {
        val email = intent.getStringExtra("email")
        if (email != null) {
            verification_text.setText("We have sent a verification code to the email $email, please check your email")
        } else {
            verification_text.setText("We have sent a verification code to the email you registered, please check your email")
        }

        token_verification_text.setOnKeyListener { v, keyCode, event ->
            val token = token_verification_text.text.toString()
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                if (!token.isEmpty()) {
                    this.validateToken()
                } else {
                    Toast.makeText(this, "Sorry, please fill token first", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            false
        }

        verify_button.setOnClickListener {
            this.validateToken()
        }
    }

    fun validateToken() {
        val token = token_verification_text.text.toString()
        if (token.uppercase() == "ABCDE") {
            this.toHome()
        } else {
            Toast.makeText(this, "Sorry, please check your token again", Toast.LENGTH_SHORT)
                .show()
        }
    }

    fun toHome () {
        val intent = Intent(this, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}