package uz.androbeck.virtualbank.modul

import android.content.Context
import android.content.SharedPreferences

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharePreferenceModule {

    const val KEY_FOR_USER_OBJ = "USER_OBJ"
    const val KEY_FOR_SPLASH_SHOWED = "KEY_FOR_SPLASH_SHOWED"
    const val SHARED_PREFERENCE_NAME = "SHARED_PREFERENCE_NAME"

    @Provides
    @Singleton
    fun getSharePreference(@ApplicationContext context: Context):SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCE_NAME,Context.MODE_PRIVATE)
    }
}