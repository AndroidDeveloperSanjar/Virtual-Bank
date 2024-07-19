package uz.androbeck.virtualbank.ui.screens.auth.registration

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.androbeck.virtualbank.modul.SharePreferenceModule
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    // it is sharedPreferences example for auth
    private val sharedPreferences: SharedPreferences
) : ViewModel() {
    private val _registrationUiEvent =
        MutableLiveData<RegistrationUiEvent>(RegistrationUiEvent.Loading)
    val registrationUiEvent: LiveData<RegistrationUiEvent> = _registrationUiEvent

    fun registration(
        // user model repository obj and server register method
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            sharedPreferences.edit().putString(SharePreferenceModule.KEY_FOR_USER_OBJ, "example user model")
                .apply()
            // registration success
            _registrationUiEvent.postValue(RegistrationUiEvent.Success)
        }
    }


}

sealed class RegistrationUiEvent {
    data object Loading : RegistrationUiEvent()
    data object Success : RegistrationUiEvent()
    data class Error(val massage: String) : RegistrationUiEvent()
}