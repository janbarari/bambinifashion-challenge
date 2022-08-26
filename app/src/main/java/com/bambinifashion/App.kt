package com.bambinifashion

import android.app.Application
import com.bambinifashion.datastore.UserDataStore
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var userDataStore: UserDataStore

    override fun onCreate() {
        super.onCreate()
        if (userDataStore.get().apiKey == "Undefined") {
            userDataStore.set(
                apiKey = "oMXmKN4YSgD8RgeFfMOF54FdyENIxp",
                localization = "AT,USD,en"
            )
        }
    }

}