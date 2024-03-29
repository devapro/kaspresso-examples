package com.kaspersky.kaspressample.screen

import com.kaspersky.kaspressample.MainActivity
import com.kaspersky.kaspressample.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

object MainScreen : KScreen<MainScreen>() {

    override val layoutId: Int = R.layout.activity_main
    override val viewClass: Class<*> = MainActivity::class.java

    val autoScrollScrollViewWithPaddingButton = KButton { withId(R.id.activity_main_auto_scroll_scrollView_with_padding_button) }

    val simpleButton = KButton { withId(R.id.activity_main_simple_sample_button) }

    val webViewButton = KButton { withId(R.id.activity_main_webview_sample_button) }

    val flakyButton = KButton { withId(R.id.activity_main_flaky_sample_button) }

    val continuouslyButton = KButton { withId(R.id.activity_main_continuously_sample_button) }

    val composeButton = KButton { withId(R.id.activity_main_complex_compose_sample_button) }

    val idleWaitingButton = KButton { withId(R.id.activity_main_idlewaiting_sample_button) }

    val systemDialogsButton = KButton { withId(R.id.activity_main_system_dialogs_button) }

    val changeLocaleButton = KButton { withId(R.id.activity_main_change_locale_mid_test_button) }

    val withToolbarButton = KButton { withId(R.id.activity_with_toolbar_button) }

    val mixedButton = KButton { withId(R.id.activity_with_mixed_views_button) }

    val descriptionText = KTextView { withId(R.id.activity_main_title) }
}
