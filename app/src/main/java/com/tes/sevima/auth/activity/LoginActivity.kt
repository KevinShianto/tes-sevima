package com.tes.sevima.auth.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.tes.sevima.R
import com.tes.sevima.base.BaseActivity
import com.tes.sevima.component.LoadingDialog
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        this.setup()
    }

    fun setup () {
        sign_up_link.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        login_button.setOnClickListener {
            val email = email_text.text.toString()
            val password = password_text.text.toString()

            loadingDialog.show(supportFragmentManager,"Loading Dialog")

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                .addOnCompleteListener{

                    if (!it.isSuccessful){ return@addOnCompleteListener
                        loadingDialog.dismiss()
                        Toast.makeText(this, "Email/Password incorrect", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        loadingDialog.dismiss()
                        Toast.makeText(this, "Succesfully Login", Toast.LENGTH_SHORT).show()
                    }
                }
                .addOnFailureListener{
                    loadingDialog.dismiss()
                    Toast.makeText(this, "Email/Password incorrect", Toast.LENGTH_SHORT).show()
                }
        }
    }
}