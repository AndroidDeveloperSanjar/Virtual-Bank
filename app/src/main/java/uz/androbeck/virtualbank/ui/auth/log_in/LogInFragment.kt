package uz.androbeck.virtualbank.ui.auth.log_in

import androidx.fragment.app.viewModels
import uz.androbeck.virtualbank.databinding.FragmentLogInBinding
import uz.androbeck.virtualbank.extentions.BaseFragment
import uz.androbeck.virtualbank.ui.main_activity.MainViewModel

class LoginFragment : BaseFragment<FragmentLogInBinding>() {

    private val viewModel: LogInViewModel by viewModels()
    private val mainViewModel by viewModels<MainViewModel>()

    override fun getVBinding(): FragmentLogInBinding {
        return FragmentLogInBinding.inflate(layoutInflater)
    }


    override fun setUp() {
        binding.btnSingIn.setOnClickListener {
            viewModel.saveIsLogin(true)
            mainViewModel.checkRegistration()
        }
        viewModel.checkRegistration()
        viewModel.logInEvent.observe(this) {
            when (it) {
                LogInEvent.Loading -> {

                }
                is LogInEvent.NotRegistered -> {

                    mainViewModel.checkRegistration()
                }
                is LogInEvent.Success -> {
                    mainViewModel.checkRegistration()
                }
            }
        }
    }
}