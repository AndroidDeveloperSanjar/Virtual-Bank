package uz.androbeck.virtualbank.ui.screens.splash

import android.annotation.SuppressLint
import android.os.CountDownTimer
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.androbeck.virtualbank.R
import uz.androbeck.virtualbank.databinding.FragmentSplashBinding
import uz.androbeck.virtualbank.ui.base.BaseFragment

@AndroidEntryPoint
class SplashFragment : BaseFragment(R.layout.fragment_splash) {
    private val binding: FragmentSplashBinding by viewBinding()
    private val viewModel: SplashViewModel by viewModels()

    private var index = 0

    // it is counter for splash screen 9 seconds liat 3 item show
    private val counter = object : CountDownTimer(3000, 1000) {
        @SuppressLint("SetTextI18n")
        override fun onTick(p0: Long) {
            with(binding) {
                if (index > 2 || viewPager2.currentItem > 2) {
                    findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                }
            }
        }

        override fun onFinish() {

            binding.viewPager2.currentItem = ++index
            if (index > 2) {
                // it is finish and navigate to login fragment
                findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            }
        }

    }

    override fun setup() {
        with(binding) {
            viewModel.uiState.observe(viewLifecycleOwner) {
                when (it) {
                    SplashUiEvent.IsSplashNotShowed -> {
                        setupViewPager()
                    }

                    SplashUiEvent.IsSplashShowed -> {
                        findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                    }

                    SplashUiEvent.Loading -> {
                        // it is loading and something works do
                    }
                }

            }

        }
    }

    private fun setupViewPager() = with(binding) {
        viewPager2.adapter = SplashAdapter()
        indicator.setViewPager(viewPager2)
        // counter star 3 sec
        counter.start()
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                index = position
                counter.cancel()
                counter.start()
            }
        })
    }


}