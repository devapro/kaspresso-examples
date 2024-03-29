package com.kaspersky.kaspressample.mixed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.dp
import com.kaspersky.kaspressample.R

@Composable
fun ComposeComplexView() {
    Column (modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .semantics { testTag = CTags.Tag.mix_screen_simple_first_button },
            content = {
                Text(text = stringResource(id = R.string.main_screen_simple_flaky_button))
            },
            onClick = {},
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .semantics { testTag = CTags.Tag.mix_screen_simple_second_button },
            content = {
                Text(text = stringResource(id = R.string.main_screen_sanity_flaky_button))
            },
            onClick = {},
        )
    }
}