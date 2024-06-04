package com.dan15d.codetest.ui.components.atoms.images

import androidx.compose.runtime.Composable
import coil.compose.AsyncImage

@Composable
fun CardAvatar(url: String) {
    AsyncImage(
        model = url,
        contentDescription = null,
    )
}