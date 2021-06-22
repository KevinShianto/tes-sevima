package com.tes.sevima.auth.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.tes.sevima.R
import com.tes.sevima.base.BaseActivity
import com.tes.sevima.home.HomeActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)
        this.setup()
    }

    fun setup () {
        sign_in_link.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        sign_up_button.setOnClickListener {
            if (validate()) {
                val email = email_text.text.toString()
                val password = password_text.text.toString()

                loadingDialog.show(supportFragmentManager, "Loading Dialog")

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (!it.isSuccessful) {
                        return@addOnCompleteListener
                        loadingDialog.dismiss()
                        Toast.makeText(this, "Wrong email format", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        loadingDialog.dismiss()
                        Toast.makeText(this, "Succesfully Register", Toast.LENGTH_SHORT).show()
                        toVerification()
                    }
                }.addOnFailureListener {
                    loadingDialog.dismiss()
                    Toast.makeText(this, "Wrong email format", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    /// Untuk validasi form sign up
    fun validate() : Boolean {
        val email = email_text.text.toString()
        val password = password_text.text.toString()
        val confirm_password = confirm_password_text.text.toString()

        if (email.isEmpty() && password.isEmpty() && confirm_password.isEmpty()) {
            Toast.makeText(this, "Sorry, please fill email and password", Toast.LENGTH_SHORT)
                .show()
            return false
        } else if (password != confirm_password){
            Toast.makeText(this, "Please make sure your password and confirm password is match", Toast.LENGTH_SHORT)
                .show()
            return false
        }
        return true
    }

    fun toVerification() {
        val intent = Intent(this, VerificationActivity::class.java)
        intent.putExtra("email", email_text.text.toString())
        startActivity(intent)
    }
}