package com.nameisjayant.compose.features.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nameisjayant.compose.R
import com.nameisjayant.compose.features.model.Ticker
import com.nameisjayant.compose.utils.tickerList


@Composable
fun TickrSection() {
    val context = LocalContext.current
    Column {
        TickerHeader()
        LazyRow(
            contentPadding = PaddingValues(vertical = 24.dp)
        ){
            items(tickerList(context),key = {it.id}){
                TickerEachRow(data = it)
            }
        }
    }
}

@Composable
fun TickerHeader(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.most_happening_tickr),
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.W600,
                color = Color.White
            )
        )
    }
}

@Composable
fun TickerEachRow(
    modifier: Modifier = Modifier,
    data: Ticker,

) {
    Column(modifier = modifier.padding(end = 24.dp)) {
        NetworkIcon(icon = data.icon, modifier = Modifier
            .size(55.dp)
            .align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = data.title,
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.W500,
                color = Color.White
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}