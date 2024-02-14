package com.kaspersky.kaspressample.external_screens

import com.kaspersky.components.kautomator.component.check.UiCheckBox
import com.kaspersky.components.kautomator.component.edit.UiEditText
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

    val edit = UiEditText { withId(this@UiMixedScreen.packageName, "edit") }

    val checkBox = UiCheckBox { withId(this@UiMixedScreen.packageName, "checkBox") }
}
