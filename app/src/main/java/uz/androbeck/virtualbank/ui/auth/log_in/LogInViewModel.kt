package uz.androbeck.virtualbank.ui.auth.log_in

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.androbeck.virtualbank.model.db.SharedPreferences.EncryptedSharedPreferencesHelper
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(private val sharedPreferencesHelper: EncryptedSharedPreferencesHelper) :
    ViewModel() {
    private val _logInEvent = MutableLiveData<LogInEvent>()
    val logInEvent: LiveData<LogInEvent> = _logInEvent
    fun saveIsLogin(isLogin: Boolean = false) {
        sharedPreferencesHelper.saveIsLogin(isLogin)
    }

    fun checkRegistration() {
        viewModelScope.launch(Dispatchers.IO) {
            if (sharedPreferencesHelper.isLogin()) {
                _logInEvent.postValue(LogInEvent.Success("success"))
            } else {
                _logInEvent.postValue(LogInEvent.NotRegistered("not registered"))
            }
            _logInEvent.postValue(LogInEvent.Loading)

        }
    }
}

sealed class LogInEvent {
    data class Success(val message: String) : LogInEvent()
    data class NotRegistered(val message: String) : LogInEvent()
    data object Loading : LogInEvent()

}