package com.example.electricity.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity() {
    abstract var contentViewId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentViewId)
        AndroidInjection.inject(this)
    }
}
