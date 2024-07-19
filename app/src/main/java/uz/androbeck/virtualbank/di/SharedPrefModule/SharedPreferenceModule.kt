package uz.androbeck.virtualbank.di.SharedPrefModule

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.androbeck.virtualbank.model.db.SharedPreferences.EncryptedSharedPreferencesHelper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {
const val MY_SHARED_PREFERENCES = "my_shared_preferences"
    const val USER_IS_REGISTERED = "user_is_registered"

    @Provides
    @Singleton
    fun provideEncryptedSharedPreferencesHelper(@ApplicationContext context: Context): EncryptedSharedPreferencesHelper {
        EncryptedSharedPreferencesHelper.initialize(context)
        return EncryptedSharedPreferencesHelper
    }
}