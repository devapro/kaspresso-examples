package com.kaspersky.kaspressample.compose.features.flaky

data class SimpleFlakyState(
    val firstButtonVisibility: Boolean,
    val secondButtonVisibility: Boolean,
    val editTextVisibility: Boolean,
    val editText: String,
)
