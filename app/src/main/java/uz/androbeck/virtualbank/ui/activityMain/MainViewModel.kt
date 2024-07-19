package uz.androbeck.virtualbank.ui.activityMain

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
class MainViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    private val _uiEvent = MutableLiveData<MainUiEvent>(MainUiEvent.Checking)
    val uiEvent: LiveData<MainUiEvent> get() = _uiEvent

    fun checkUserIsRegistered() {
        viewModelScope.launch(Dispatchers.IO) {
            if (sharedPreferences.getString(SharePreferenceModule.KEY_FOR_USER_OBJ, null) != null) {
                // it is gson  and it -> User fo Gson
                _uiEvent.postValue(MainUiEvent.Successfully)
                println(" it is registirated")
            } else {
                println(" it is not registirated")
                _uiEvent.postValue(MainUiEvent.NotRegistered)
            }
        }
    }

}

sealed class MainUiEvent {
    data object Checking : MainUiEvent()
    data object NotRegistered : MainUiEvent()
    data object Successfully : MainUiEvent()
    data class Error(val message: String) : MainUiEvent()
}