package uz.androbeck.virtualbank.ui.PaymentsFragment

import uz.androbeck.virtualbank.databinding.FragmentPaymentsBinding
import uz.androbeck.virtualbank.extentions.BaseFragment


class PaymentsFragment : BaseFragment<FragmentPaymentsBinding>() {
    override fun getVBinding(): FragmentPaymentsBinding {
        return FragmentPaymentsBinding.inflate(layoutInflater)
    }

    override fun setUp() {
        TODO("Not yet implemented")
    }

}