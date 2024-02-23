package com.nameisjayant.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.nameisjayant.compose.features.bottombar.BottomBarScreen
import com.nameisjayant.compose.features.navigation.AppNavigation
import com.nameisjayant.compose.features.ui.screens.HomeScreen
import com.nameisjayant.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                val navHostController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomAppBar(
                            containerColor = Color.Black
                        ) {
                            BottomBarScreen(navHostController = navHostController)
                        }
                    }
                ) { paddingValues ->
                    AppNavigation(
                        navHostController = navHostController,
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }
}