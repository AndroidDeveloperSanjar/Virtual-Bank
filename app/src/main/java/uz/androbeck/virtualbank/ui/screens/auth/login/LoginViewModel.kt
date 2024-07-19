package uz.androbeck.virtualbank.ui.screens.auth.login

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.androbeck.virtualbank.modul.SharePreferenceModule
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    fun splashScreenShowed() {
        CoroutineScope(Dispatchers.IO).launch {
            sharedPreferences.edit()
                .putBoolean(SharePreferenceModule.KEY_FOR_SPLASH_SHOWED, true)
                .apply()
        }
    }
}