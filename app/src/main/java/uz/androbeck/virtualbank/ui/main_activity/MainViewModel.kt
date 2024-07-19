package uz.androbeck.virtualbank.ui.main_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.androbeck.virtualbank.model.db.SharedPreferences.EncryptedSharedPreferencesHelper
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sharedPreferencesHelper: EncryptedSharedPreferencesHelper
) : ViewModel() {
    private val _getMainEvent = MutableLiveData<GetMainEvent>()
    val getMainEvent: LiveData<GetMainEvent> = _getMainEvent

    fun checkRegistration() {
        viewModelScope.launch(Dispatchers.IO) {
            if (sharedPreferencesHelper.isLogin() ) {
                _getMainEvent.postValue(GetMainEvent.Success("success"))
            }else{
                _getMainEvent.postValue(GetMainEvent.NotRegistered("not registered"))
            }
        }
    }


}

sealed class GetMainEvent {
    data class Success(val message: String) : GetMainEvent()
    data class NotRegistered(val message: String) : GetMainEvent()
    data object Loading : GetMainEvent()

}