package com.nameisjayant.compose.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nameisjayant.compose.R
import com.nameisjayant.compose.ui.theme.DarkGreenColor
import com.nameisjayant.compose.ui.theme.GreenColor
import com.nameisjayant.compose.ui.theme.GreenLinearGradient
import com.nameisjayant.compose.ui.theme.LightGrayColor


@Composable
fun RapidFireSection(
    onClick: () -> Unit
) {
    RapidFireHeader()
    Spacer(modifier = Modifier.height(10.dp))
    Box(
        modifier = Modifier.padding(top = 20.dp)
    ) {
        RapidFireQuestion(
            backgroundColor = Brush.linearGradient(listOf(Color(0XFFF87871),Color(0XFFF87871))),
            modifier = Modifier.graphicsLayer {
                this.rotationZ = -179f

            }
        )
        RapidFireQuestion{
            onClick()
        }
    }
}

@Composable
fun RapidFireHeader(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            text = stringResource(R.string.rapid_fire),
            style = MaterialTheme.typography.titleSmall.copy(
                color = Color.White,
                fontWeight = FontWeight.W600
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = stringResource(R.string._5_questions),
            style = MaterialTheme.typography.labelLarge.copy(
                color = LightGrayColor,
                fontWeight = FontWeight.W400
            ),
        )
    }
}

@Composable
fun RapidFireQuestion(
    modifier: Modifier = Modifier,
    backgroundColor: Brush = GreenLinearGradient,
    onClick:()->Unit ={}
) {
    Column(
        modifier = modifier
            .padding(top = 16.dp)
            .background(backgroundColor, RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.will_leeds_lead_at_half_time),
            style = MaterialTheme.typography.titleSmall.copy(
                color = Color.White,
                fontWeight = FontWeight.W600,
                fontSize = 24.sp
            ),
        )
        Row(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                AppIconComponent(
                    icon = R.drawable.coin,
                    modifier = Modifier
                        .size(
                            12.dp
                        )
                        .align(Alignment.CenterVertically),
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = stringResource(R.string._50_coins),
                    style = androidx.compose.material3.LocalTextStyle.current.copy(
                        color = Color.Yellow,
                        fontWeight = FontWeight.W500,
                    ),
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            BetRow()
        }
        Spacer(modifier = Modifier.padding(top = 24.dp))
        Row {
            Row(
                modifier = Modifier.weight(1f)
            ) {
                Button(
                    onClick = onClick, colors = ButtonDefaults.buttonColors(
                        containerColor = DarkGreenColor
                    ),
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .width(120.dp)
                        .height(40.dp)
                ) {
                    Text(text = stringResource(R.string.yes))
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = onClick, colors = ButtonDefaults.buttonColors(
                        containerColor = DarkGreenColor
                    ),
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .width(120.dp)
                        .height(40.dp)
                ) {
                    Text(text = stringResource(R.string.no))
                }
            }
            Text(
                text = stringResource(R.string.skip),
                modifier = Modifier.align(Alignment.CenterVertically),
                color = Color.White
            )
        }
    }
}

@Composable
fun BetRow() {
    var selected by remember { mutableIntStateOf(0) }
    val list = listOf("1x", "2x", "5x", "10x")

    Row(
        modifier = Modifier
            .border(
                1.dp,
                GreenColor,
                RoundedCornerShape(8.dp)
            )
    ) {
        list.forEachIndexed { index, s ->
            Box(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .background(
                        color = if (selected == index) Color.White.copy(alpha = 0.333f) else Color.Transparent,
                        RoundedCornerShape(8.dp)
                    )
                    .clickable {
                        selected = index
                    }
            ) {
                Text(
                    text = s,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    color = Color.White
                )
            }
        }
    }

}