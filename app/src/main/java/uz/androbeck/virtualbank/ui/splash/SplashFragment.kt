package uz.androbeck.virtualbank.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.androbeck.virtualbank.databinding.FragmentSplashBinding
import uz.androbeck.virtualbank.extentions.BaseFragment
import uz.androbeck.virtualbank.ui.main_activity.MainActivity

class SplashFragment: BaseFragment<FragmentSplashBinding>() {

    override fun getVBinding(): FragmentSplashBinding {
      return FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun setUp() {
        lifecycleScope.launch {
            delay(2000L)
            if (isAdded) {
                startNavGraph()
            }
        }
    }
    private fun startNavGraph() {
        (requireActivity() as? MainActivity)?.starNavGraph()
    }
}