package com.bambinifashion.datastore

import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class UserDataStore(private val context: Context) {

    private val sharedPref: SharedPreferences =
        context.getSharedPreferences("user_shared_prefs", Context.MODE_PRIVATE)

    fun set(apiKey: String, localization: String) {
        val editor = sharedPref.edit()
        editor.putString("apiKey", apiKey)
        editor.putString("localization", localization)
        editor.apply()
    }

    fun get(): UserData {
        val apiKey: String = sharedPref.getString("apiKey", "Undefined")!!
        val localization: String = sharedPref.getString("localization", "Undefined")!!
        return UserData(apiKey = apiKey, localization = localization)
    }

}