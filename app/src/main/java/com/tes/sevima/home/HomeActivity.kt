package com.tes.sevima.home

import android.os.Bundle
import com.tes.sevima.R
import com.tes.sevima.base.BaseActivity
import com.tes.sevima.home.pages.HomeFragmentAdapter
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        this.setup()
    }

    fun setup () {
        view_pager.adapter = HomeFragmentAdapter(supportFragmentManager)
    }
}