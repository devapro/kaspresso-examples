package com.kaspersky.kaspressample.mixed

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import com.kaspersky.kaspresso.composesupport.sample.resources.C

class WrapperView  @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    init {
        addView(
            ComposeView(context).apply {
                setContent {
                    MaterialTheme {
                        Box(
                            modifier = Modifier
                                .semantics { testTag = CTags.Tag.mix_screen_container }
                        ) {
                            ComposeComplexView()
                        }
                    }
                }
            }
        )
    }
}