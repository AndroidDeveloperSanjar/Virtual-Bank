package uz.androbeck.virtualbank.model.db.SharedPreferences

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys


object EncryptedSharedPreferencesHelper {

        private const val SHARED_PREFS_NAME = "app_db"
        private const val IS_LOGIN = "is_login"
        private const val IS_REGISTRATION = "is_registration"

        private lateinit var encryptedSharedPreferences: EncryptedSharedPreferences

         fun getEncryptedSharedPreferences(): EncryptedSharedPreferences {
             return encryptedSharedPreferences
         }
        fun initialize(context: Context) {
            val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
            encryptedSharedPreferences = EncryptedSharedPreferences.create(
                SHARED_PREFS_NAME,
                masterKeyAlias,
                context,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            ) as EncryptedSharedPreferences
        }

        private fun saveBoolean(key: String, value: Boolean) {
            encryptedSharedPreferences.edit().putBoolean(key, value).apply()
        }

        private fun getBoolean(key: String): Boolean {
            return encryptedSharedPreferences.getBoolean(key, false)
        }

        fun isLogin() = getBoolean(IS_LOGIN)

        fun isRegistration() = getBoolean(IS_REGISTRATION)

        fun saveIsLogin(isLogin: Boolean = false) {
            saveBoolean(IS_LOGIN, isLogin)
        }

        fun saveIsRegister(isRegister: Boolean = false) {
            saveBoolean(IS_REGISTRATION, isRegister)
        }

        fun clear() {
            encryptedSharedPreferences.edit().clear().apply()
        }
    }