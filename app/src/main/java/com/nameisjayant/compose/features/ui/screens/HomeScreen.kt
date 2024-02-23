package com.nameisjayant.compose.features.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nameisjayant.compose.R
import com.nameisjayant.compose.features.components.CategorySection
import com.nameisjayant.compose.features.components.HeaderComponent
import com.nameisjayant.compose.features.components.LiveMatchSection
import com.nameisjayant.compose.features.components.RapidFireSection
import com.nameisjayant.compose.features.components.TickrSection
import com.nameisjayant.compose.ui.theme.BlueColor
import com.nameisjayant.compose.ui.theme.LightGrayColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var selectedSection by remember { mutableIntStateOf(0) }
    val sheetState = rememberModalBottomSheetState()
    var showSheet by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            HeaderComponent()
            CategorySection(selectedSection = selectedSection, onValueChange = {
                selectedSection = it
            })
            when (selectedSection) {
                0 -> {
                    LiveMatchSection()
                    TickrSection()
                    Image(
                        painter = painterResource(id = R.drawable.ads),
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    RapidFireSection {
                        showSheet = true
                    }
                }

                else -> {}
            }
        }
    }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState,
            containerColor = Color.Black.copy(0.8f),
            scrimColor = Color.Black.copy(alpha = 0.5f)
        ) {
            Column(
                modifier = Modifier.padding(vertical = 20.dp).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.coin_1), contentDescription = null)
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = stringResource(R.string.betta_coins_are_your_besties_which_get_you_rewards),
                    color = LightGrayColor,
                    fontWeight = FontWeight.W400,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {}, colors = ButtonDefaults.buttonColors(
                        containerColor = BlueColor
                    ), shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = stringResource(R.string.explore_rewards))
                }
            }
        }
    }

}

