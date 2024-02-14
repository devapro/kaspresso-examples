package com.kaspersky.kaspressample.mixed

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView

class WrapperView  @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    init {
        addView(
            ComposeView(context).apply {
                setContent {
                    MaterialTheme {
                        ComposeComplexView()
                    }
                }
            }
        )
    }
}