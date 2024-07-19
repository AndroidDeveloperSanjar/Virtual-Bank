package uz.androbeck.virtualbank.ui.auth.sing_up

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
class SingUpViewModel @Inject constructor(
    private val sharedPreferencesHelper: EncryptedSharedPreferencesHelper
) :    ViewModel() {

    private val _singUpEvent = MutableLiveData<SingUpEvent>()
    val singUpEvent: LiveData<SingUpEvent> = _singUpEvent

    fun checkRegistration() {
        viewModelScope.launch(Dispatchers.IO) {
            println("a")
            if (sharedPreferencesHelper.isRegistration()) {
                println("b")
                _singUpEvent.postValue(SingUpEvent.Success("success"))
            } else {
                println("c")
                _singUpEvent.postValue(SingUpEvent.NotRegistered("not registered"))
            }
            _singUpEvent.postValue(SingUpEvent.Loading)

        }

    }

    fun saveIsRegister(isRegister: Boolean = false) {
        sharedPreferencesHelper.saveIsRegister(isRegister)
    }


}

sealed class SingUpEvent {
    data class Success(val message: String) : SingUpEvent()
    data class NotRegistered(val message: String) : SingUpEvent()
    data object Loading : SingUpEvent()
}
