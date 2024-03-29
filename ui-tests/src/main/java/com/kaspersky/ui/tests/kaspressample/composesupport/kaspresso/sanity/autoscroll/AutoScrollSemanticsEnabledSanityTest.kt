package com.kaspersky.kaspressample.composesupport.kaspresso.sanity.autoscroll

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.components.composesupport.interceptors.behavior.impl.autoscroll.AutoScrollSemanticsBehaviorInterceptor
import com.kaspersky.kaspressample.compose.MainComposeActivity
import com.kaspersky.kaspressample.composesupport.sample.screen.ComposeMainScreen
import com.kaspersky.kaspressample.composesupport.sample.screen.ComposeScrollScreen
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.logger.UiTestLoggerImpl
import com.kaspersky.kaspresso.params.AutoScrollParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.compose.node.element.ComposeScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AutoScrollSemanticsEnabledSanityTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withComposeSupport(
        lateComposeCustomize = { composeBuilder ->
            composeBuilder.semanticsBehaviorInterceptors = mutableListOf(AutoScrollSemanticsBehaviorInterceptor(UiTestLoggerImpl(Kaspresso.DEFAULT_TEST_LOGGER_TAG), AutoScrollParams.default()))
        }
    )
) {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainComposeActivity>()

    @Test
    fun test() = run {
        step("Open Flaky screen") {
            ComposeScreen.onComposeScreen<ComposeMainScreen>(composeTestRule) {
                scrollButton {
                    performClick()
                }
            }
        }

        step("Click on the First button") {
            ComposeScreen.onComposeScreen<ComposeScrollScreen>(composeTestRule) {
                firstButton {
                    assertIsDisplayed()
                    performClick()
                }
            }
        }

        step("Click on the Last button") {
            ComposeScreen.onComposeScreen<ComposeScrollScreen>(composeTestRule) {
                lastButton {
                    assertIsDisplayed()
                    performClick()
                }
            }
        }
    }
}
