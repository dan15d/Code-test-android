package com.dan15d.codetest.ui.components.atoms.images

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun AsyncDetailAvatar(url: String) {
    AsyncImage(
        model = url,
        contentDescription = null,
        modifier = Modifier.size(80.dp)
    )
}