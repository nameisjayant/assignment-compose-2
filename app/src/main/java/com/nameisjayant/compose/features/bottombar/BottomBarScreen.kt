package com.nameisjayant.compose.features.bottombar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.nameisjayant.compose.features.components.AppIconComponent
import com.nameisjayant.compose.ui.theme.GrayColor


@Composable
fun BottomBarScreen(
    navHostController: NavHostController
) {
    val tabs = listOf(
        BottomBarRoute.HOME,
        BottomBarRoute.EXPLORE,
        BottomBarRoute.Write,
        BottomBarRoute.Like,
        BottomBarRoute.Account
    )

    val navStackBackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        tabs.forEach {
            BottomBarRow(
                tab = it,
                currentDestination = currentDestination,
                navHostController = navHostController
            )
        }
    }
}

@Composable
fun BottomBarRow(
    modifier: Modifier = Modifier,
    tab: BottomBarRoute,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == tab.route } == true
    val color = if (selected) Color.White else GrayColor

    IconButton(onClick = {
        navHostController.navigate(tab.route) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }, modifier = modifier) {
        AppIconComponent(icon = tab.icon, tint = color)
    }
}