package com.star_zero.androidtemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.star_zero.androidtemplate.core.Utils
import com.star_zero.androidtemplate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
    }

    fun onClickButton() {
        Utils.sample()

        val intent = Intent(this, Class.forName("com.star_zero.androidtemplate.dynamicfeature.DynamicFeatureActivity"))
        startActivity(intent)
    }
}
