package uz.androbeck.virtualbank.ui.HomeFragment

import uz.androbeck.virtualbank.databinding.FragmentHomeBinding
import uz.androbeck.virtualbank.extentions.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getVBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun setUp() {
    }

}