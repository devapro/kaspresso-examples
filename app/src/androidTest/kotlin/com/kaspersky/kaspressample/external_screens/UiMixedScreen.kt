package com.kaspersky.kaspressample.external_screens

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.kaspressample.R
import com.kaspersky.kaspressample.mixed.MixedViewsActivity

object UiMixedScreen : UiSampleScreen<UiMixedScreen>() {

    override val layoutId: Int? = R.layout.activity_mixed
    override val viewClass: Class<*>? = MixedViewsActivity::class.java

    val button1 = UiButton { withId(this@UiMixedScreen.packageName, "button_1") }

    val button2 = UiButton { withId(this@UiMixedScreen.packageName, "button_2") }

    val textView = UiTextView { withId(this@UiMixedScreen.packageName, "textview") }

    val textViewTitle = UiTextView { withId(this@UiMixedScreen.packageName, "text_view_title") }

    val wrapperView = UiView { withId(this@UiMixedScreen.packageName, "wrapper_view") }
}
