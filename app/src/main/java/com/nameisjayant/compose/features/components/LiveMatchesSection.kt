package com.nameisjayant.compose.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nameisjayant.compose.R
import com.nameisjayant.compose.features.model.Matches
import com.nameisjayant.compose.ui.theme.BorderColor
import com.nameisjayant.compose.ui.theme.DarkGrayColor
import com.nameisjayant.compose.ui.theme.LightGrayColor
import com.nameisjayant.compose.ui.theme.YellowColor
import com.nameisjayant.compose.utils.matchesList


@Composable
fun LiveMatchSection(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Column(modifier = modifier) {
        LiveMatchedTitle()
        LazyRow(
            contentPadding = PaddingValues(vertical = 24.dp)
        ) {
           items(matchesList(context)){
               MatchesEachRow(data = it)
           }
        }
    }
}

@Composable
private fun LiveMatchedTitle(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.live), style = MaterialTheme.typography.labelSmall.copy(
                color = Color.White,
                fontWeight = FontWeight.W600
            ),
            modifier = Modifier
                .drawBehind {
                    drawRoundRect(
                        color = Color.Red,
                        cornerRadius = CornerRadius(10f)
                    )
                }
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = stringResource(R.string.live_matches),
            style = MaterialTheme.typography.titleSmall.copy(
                color = Color.White,
                fontWeight = FontWeight.W600
            ),
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }

}

@Composable
fun MatchesEachRow(
    modifier: Modifier = Modifier,
    data:Matches
) {
    Column(
        modifier = modifier
            .width(IntrinsicSize.Max)
            .padding(end = 16.dp)
            .border(1.dp, BorderColor, RoundedCornerShape(10.dp))
            .background(DarkGrayColor, RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .padding(16.dp)
        ) {
            Row {
                Column {
                   NetworkIcon(icon = data.country1Icon, modifier = Modifier.align(Alignment.CenterHorizontally))
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = data.country1,
                        style = MaterialTheme.typography.titleSmall.copy(
                            color = Color.White,
                            fontWeight = FontWeight.W500
                        ),
                    )
                    Text(
                        text = data.country1Score,
                        style = MaterialTheme.typography.titleSmall.copy(
                            color = Color.White,
                            fontWeight = FontWeight.W500,
                            fontSize = 30.sp
                        ),
                        modifier = modifier
                            .padding(top = 20.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }
                Column(
                    modifier = Modifier.fillMaxHeight(1f),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.vs),
                        style = MaterialTheme.typography.titleSmall.copy(
                            color = LightGrayColor,
                            fontWeight = FontWeight.W600
                        ),
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    Text(
                        text = data.minutes,
                        style = MaterialTheme.typography.titleSmall.copy(
                            color = YellowColor,
                            fontWeight = FontWeight.W600
                        ),
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )


                }
                Column {
                    NetworkIcon(icon = data.country2Icon,modifier = Modifier.align(Alignment.CenterHorizontally))
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = data.country2,
                        style = MaterialTheme.typography.titleSmall.copy(
                            color = Color.White,
                            fontWeight = FontWeight.W500
                        ),
                    )
                    Text(
                        text = data.country2Score,
                        style = MaterialTheme.typography.titleSmall.copy(
                            color = Color.White,
                            fontWeight = FontWeight.W500,
                            fontSize = 30.sp
                        ),
                        modifier = modifier
                            .padding(top = 20.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .background(LightGrayColor)
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.bet_now),
                style = MaterialTheme.typography.titleSmall.copy(
                    color = Color.White,
                    fontWeight = FontWeight.W600
                ),
            )
        }
    }
}
