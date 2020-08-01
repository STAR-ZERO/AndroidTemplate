package com.star_zero.androidtemplate.dynamicfeature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.star_zero.androidtemplate.core.Utils
import com.star_zero.androidtemplate.dynamicfeature.databinding.ActivityDynamicFeatureBinding

class DynamicFeatureActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDynamicFeatureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_dynamic_feature
        )
        binding.hello = "Hello Dynamic Feature"

        Utils.sample()
    }
}
