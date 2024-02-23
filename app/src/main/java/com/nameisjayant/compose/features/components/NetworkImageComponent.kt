package com.nameisjayant.compose.features.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest


@Composable
fun NetworkIcon(
    modifier : Modifier = Modifier,
    icon:String,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(icon)
            .crossfade(true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(CircleShape)
            .size(28.dp),
    )
}