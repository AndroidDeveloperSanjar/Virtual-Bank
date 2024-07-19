package uz.androbeck.virtualbank.ui.screens.auth.registration

import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.androbeck.virtualbank.R
import uz.androbeck.virtualbank.databinding.FragmentRegistrationBinding
import uz.androbeck.virtualbank.ui.activityMain.MainViewModel
import uz.androbeck.virtualbank.ui.base.BaseFragment

@AndroidEntryPoint
class RegistrationFragment : BaseFragment(R.layout.fragment_registration) {
    private val binding: FragmentRegistrationBinding by viewBinding()

    // shu yerda menda taklif bor registerViewmodel bilan manin view modelni bitta qilib main viewmodel qilib qo'ysak
    private val viewModel: RegistrationViewModel by viewModels()
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun setup() {
        binding.registered.setOnClickListener {
            viewModel.registration()
        }
        viewModel.registrationUiEvent.observe(viewLifecycleOwner) {
            when (it) {
                is RegistrationUiEvent.Error -> {
                    Toast.makeText(requireContext(), it.massage, Toast.LENGTH_SHORT).show()
                }

                RegistrationUiEvent.Loading -> {

                }

                RegistrationUiEvent.Success -> {
                    mainViewModel.checkUserIsRegistered()
                }
            }
        }
    }
}