package uz.androbeck.virtualbank

import android.app.Application
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import uz.androbeck.virtualbank.model.db.SharedPreferences.EncryptedSharedPreferencesHelper
import javax.inject.Inject

@HiltAndroidApp
class DiApplication:Application() {
}