package com.nameisjayant.compose.features.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nameisjayant.compose.R


@Composable
fun HeaderComponent(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AppIconComponent(
            icon = R.drawable.app_icon,
            modifier = Modifier
                .size(44.dp)
                .align(Alignment.CenterVertically)
        )
        Row {
            IconWithBackground(icon = R.drawable.wallet)
            Spacer(modifier = Modifier.width(16.dp))
            IconWithBackground(icon = R.drawable.notification)
        }
    }
}