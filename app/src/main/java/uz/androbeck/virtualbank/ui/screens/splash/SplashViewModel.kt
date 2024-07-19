package uz.androbeck.virtualbank.ui.screens.splash

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
class SplashViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    private val _uiState = MutableLiveData<SplashUiEvent>(SplashUiEvent.Loading)
    val uiState: LiveData<SplashUiEvent> get() = _uiState

    // it is check is splash show
    init {
        checkIsSplashShowed()
    }

    private fun checkIsSplashShowed() {
        viewModelScope.launch(Dispatchers.IO) {
            if (sharedPreferences.getBoolean(SharePreferenceModule.KEY_FOR_SPLASH_SHOWED, false)) {
                _uiState.postValue(SplashUiEvent.IsSplashShowed)
            } else _uiState.postValue(SplashUiEvent.IsSplashNotShowed)
        }
    }
}

sealed class SplashUiEvent {
    data object Loading : SplashUiEvent()
    data object IsSplashShowed : SplashUiEvent()
    data object IsSplashNotShowed : SplashUiEvent()


}