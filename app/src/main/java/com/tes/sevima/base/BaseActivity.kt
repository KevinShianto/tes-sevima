package com.tes.sevima.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.tes.sevima.component.LoadingDialog

open class BaseActivity: AppCompatActivity() {
    val loadingDialog = LoadingDialog()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
}