package uz.androbeck.virtualbank.ui.screens.auth.login

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.androbeck.virtualbank.R
import uz.androbeck.virtualbank.databinding.FragmentLoginBinding
import uz.androbeck.virtualbank.ui.base.BaseFragment
@AndroidEntryPoint
class LoginFragment : BaseFragment(R.layout.fragment_login) {
    private val binding: FragmentLoginBinding by viewBinding()
    private val viewModel: LoginViewModel by viewModels()
    override fun setup() {

        // it is login fragment to -> registration fragment
        binding.toRegistered.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
            Toast.makeText(requireContext(), "Click", Toast.LENGTH_SHORT).show()
        }

        // it is splash showed save
       viewModel.splashScreenShowed()


    }
}