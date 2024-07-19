package uz.androbeck.virtualbank.ui.auth.choose

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.androbeck.virtualbank.R
import uz.androbeck.virtualbank.databinding.FragmentChoseBinding
import uz.androbeck.virtualbank.extentions.BaseFragment
import uz.androbeck.virtualbank.model.db.SharedPreferences.EncryptedSharedPreferencesHelper
import uz.androbeck.virtualbank.ui.main_activity.MainViewModel
import javax.inject.Inject


@AndroidEntryPoint
class ChoseFragment : BaseFragment<FragmentChoseBinding>() {
    @Inject
    lateinit var sharedPreferencesHelper: EncryptedSharedPreferencesHelper

    private val viewModel by viewModels<MainViewModel>()
    override fun getVBinding(): FragmentChoseBinding {
        return FragmentChoseBinding.inflate(layoutInflater)
    }


    override fun setUp() {
        if (sharedPreferencesHelper.isLogin()) {
            viewModel.checkRegistration()
        } else {
            if (sharedPreferencesHelper.isRegistration()) {
                findNavController().navigate(R.id.action_choseFragment_to_loginFragment)
            } else {
                findNavController().navigate(R.id.action_choseFragment_to_singUpFragment)
            }
        }
    }

}