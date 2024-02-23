package com.nameisjayant.compose.features.components

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.nameisjayant.compose.ui.theme.DarkBlueColor


@Composable
fun IconWithBackground(
    modifier: Modifier = Modifier,
    @DrawableRes icon:Int?=null,
    imageVector: ImageVector?= null,
    backgroundColor:Color = DarkBlueColor
) {

    icon?.let {
        AppIconComponent(icon = it, modifier = modifier.drawBehind {
            drawCircle(
                color = backgroundColor,
            )
        }.padding(16.dp))
    }
    imageVector?.let {
        AppIconComponent(imageVector = it, modifier = modifier.drawBehind {
            drawCircle(
                color = backgroundColor,
            )
        }.padding(10.dp))
    }

}