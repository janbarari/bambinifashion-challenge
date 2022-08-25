package com.bambinifashion.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

class UserDataStore(private val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")

    companion object {
        val API_KEY = stringPreferencesKey("API_KEY")
        val LOCALIZATION = stringPreferencesKey("LOCALIZATION")
    }

    suspend fun set(apiKey: String, localization: String) {
        context.dataStore.edit {
            it[API_KEY] = apiKey
            it[LOCALIZATION] = localization
        }
    }

    fun get(): UserData? {
        var userData: UserData? = null
        context.dataStore.data.filter {
            it[API_KEY] != null &&
                    it[LOCALIZATION] != null
        }.map {
            userData = UserData(
                apiKey = it[API_KEY]!!,
                localization = it[LOCALIZATION]!!
            )
        }
        return userData
    }

}