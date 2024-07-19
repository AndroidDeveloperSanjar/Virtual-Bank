package uz.androbeck.virtualbank.ui.auth.sing_up

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.androbeck.virtualbank.databinding.FragmentSingUpBinding
import uz.androbeck.virtualbank.extentions.BaseFragment
import uz.androbeck.virtualbank.ui.main_activity.GetMainEvent
import uz.androbeck.virtualbank.ui.main_activity.MainViewModel

@AndroidEntryPoint
class SingUpFragment : BaseFragment<FragmentSingUpBinding>() {
    private val mainViewModel by viewModels<MainViewModel>()
    private val viewModel:SingUpViewModel by viewModels()
    override fun getVBinding(): FragmentSingUpBinding {
        return FragmentSingUpBinding.inflate(layoutInflater)
    }

    override fun setUp() {
        binding.btnSignup.setOnClickListener {
            viewModel.saveIsRegister(true)

            mainViewModel.checkRegistration()
        }
        mainViewModel.checkRegistration()
        viewModel.singUpEvent.observe(this) {
            when (it) {
                SingUpEvent.Loading -> {

                }
                is SingUpEvent.NotRegistered -> {
                 mainViewModel.checkRegistration()
                }
                is SingUpEvent.Success -> {
                    mainViewModel.checkRegistration()
                }
            }
        }
    }


}