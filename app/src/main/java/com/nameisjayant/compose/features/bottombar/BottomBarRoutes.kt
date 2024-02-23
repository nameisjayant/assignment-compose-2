package com.nameisjayant.compose.features.bottombar


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.nameisjayant.compose.R

enum class BottomBarRoute(
    val route: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int
) {
    HOME("/home", R.string.home, R.drawable.home),
    EXPLORE("/explore", R.string.explore, R.drawable.explore),
    Write("/write", R.string.write, R.drawable.write),
    Like("/like", R.string.like, R.drawable.like),
    Account("/account", R.string.account, R.drawable.account)
}