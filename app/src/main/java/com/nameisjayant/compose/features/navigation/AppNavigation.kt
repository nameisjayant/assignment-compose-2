package com.nameisjayant.compose.features.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nameisjayant.compose.features.bottombar.BottomBarRoute
import com.nameisjayant.compose.features.ui.screens.HomeScreen


@Composable
fun AppNavigation(
    navHostController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = "Main",
        modifier
    ) {
        navigation(
            startDestination = BottomBarRoute.HOME.route,
            route = "Main"
        ) {
            composable(BottomBarRoute.HOME.route) {
                HomeScreen()
            }
            composable(BottomBarRoute.Account.route) {

            }
            composable(BottomBarRoute.Write.route) {

            }
            composable(BottomBarRoute.EXPLORE.route) {

            }
            composable(BottomBarRoute.Like.route) {
            }

        }
    }
}