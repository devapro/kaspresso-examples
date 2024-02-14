package com.kaspersky.kaspressample.external_screens

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.kaspersky.kaspressample.mixed.CTags
import com.kaspersky.kaspresso.composesupport.sample.resources.C
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class ComposeUiMixedScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<ComposeUiMixedScreen>(
        semanticsProvider = semanticsProvider,
        viewBuilderAction = { hasTestTag(CTags.Tag.mix_screen_container) }
    ) {

    val firstButton: KNode = child {
        hasTestTag(CTags.Tag.mix_screen_simple_first_button)
    }

    val secondButton: KNode = child {
        hasTestTag(CTags.Tag.mix_screen_simple_second_button)
    }
}
