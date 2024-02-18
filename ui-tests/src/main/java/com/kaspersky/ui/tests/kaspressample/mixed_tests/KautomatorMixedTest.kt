package com.kaspersky.ui.tests.kaspressample.mixed_tests

import android.Manifest
import android.os.Build
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspressample.MainActivity
import com.kaspersky.kaspressample.R
import com.kaspersky.kaspressample.external_screens.ComposeUiMixedScreen
import com.kaspersky.kaspressample.external_screens.UiMainScreen
import com.kaspersky.kaspressample.external_screens.UiMixedScreen
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.compose.node.element.ComposeScreen
import org.junit.Assume
import org.junit.Rule
import org.junit.Test

class KautomatorMixedTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withComposeSupport(
        lateComposeCustomize = { composeBuilder ->
            composeBuilder.semanticsBehaviorInterceptors = mutableListOf()
        }
    )
) {

    companion object {
        private val RANGE = 0..20
    }

    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val composeTestRule = createAndroidComposeRule<com.kaspersky.kaspressample.compose.MainComposeActivity>()

    @Test
    fun test() = before {
        Assume.assumeTrue(" KautomatorWaitForIdleSettings.boost() works incorrectly on Android 5", Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP)
    }.after { }.run {
        step("MainScreen. Click on `mixed fragment` button") {
            UiMainScreen {
                scrollToTheEnd()
                mixedButton {
                    isDisplayed()
                    click()
                }
            }
        }

        step("Mixed screen. Button_1 clicks comparing") {
            UiMixedScreen {
                RANGE.forEach { _ ->
                    button1 {
                        click()
                        hasText(device.targetContext.getString(R.string.measure_fragment_text_button_1))
                    }
                }
            }
        }

        step("Mixed screen. Button_2 clicks and TextView changes comparing") {
            UiMixedScreen {
                RANGE.forEach { index ->
                    button2 {
                        click()
                        hasText(device.targetContext.getString(R.string.measure_fragment_text_button_2))
                    }
                    textView {
                        hasText(
                            "${device.targetContext.getString(R.string.measure_fragment_text_textview)}${index + 1}"
                        )
                    }
                }
            }
        }

        step("Click on the First button") {
            ComposeScreen.onComposeScreen<ComposeUiMixedScreen>(composeTestRule) {
                firstButton {
                    assertIsDisplayed()
                    performClick()
                }
            }
        }

        step("Click on the Second button") {
            ComposeScreen.onComposeScreen<ComposeUiMixedScreen>(composeTestRule) {
                secondButton {
                    assertIsDisplayed()
                    performClick()
                }
            }
        }
    }
}
