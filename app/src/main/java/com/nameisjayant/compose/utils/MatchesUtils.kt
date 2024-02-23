package com.nameisjayant.compose.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nameisjayant.compose.features.model.Matches
import java.io.IOException


fun matchesList(context: Context): MutableList<Matches> {
    val jsonFileString = getJsonDataFromAsset(context = context, "matches.json")
    val type = object : TypeToken<List<Matches>>() {}.type
    return Gson().fromJson(jsonFileString, type)
}

fun getJsonDataFromAsset(
    context: Context,
    fileName: String
): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
    } catch (exp: IOException) {
        exp.printStackTrace()
        return null
    }
    return jsonString
}