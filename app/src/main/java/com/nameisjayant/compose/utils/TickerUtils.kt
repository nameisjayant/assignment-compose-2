package com.nameisjayant.compose.utils


import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nameisjayant.compose.features.model.Ticker


fun tickerList(context: Context): MutableList<Ticker> {
    val jsonFileString = getJsonDataFromAsset(context = context, "ticker.json")
    val type = object : TypeToken<List<Ticker>>() {}.type
    return Gson().fromJson(jsonFileString, type)
}
