package com.kaspersky.kaspressample.mixed

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kaspersky.kaspressample.R
import com.kaspersky.kaspressample.databinding.ActivityMeasureBinding
import com.kaspersky.kaspressample.databinding.ActivityMixedBinding

class MixedViewsActivity : AppCompatActivity() {

    private var button2ClicksCount = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMixedBinding.inflate(layoutInflater)
        binding.textview.text = "${getString(R.string.measure_fragment_text_textview)}$button2ClicksCount"
        binding.button2.setOnClickListener {
            button2ClicksCount++
            binding.textview.text = "${getString(R.string.measure_fragment_text_textview)}$button2ClicksCount"
        }

        setContentView(binding.root)
    }
}
