package com.bambinifashion.bag

import android.view.View
import com.bambinifashion.architecture.fragment.BaseFragment
import com.bambinifashion.bag.databinding.BagFragmentBinding

class BagFragment: BaseFragment<BagFragmentBinding>(
    R.layout.bag_fragment
) {
    override fun getBindingLayout(v: View): BagFragmentBinding {
        return BagFragmentBinding.bind(v)
    }


}
