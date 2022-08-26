package com.bambinifashion.designers

import android.view.View
import com.bambinifashion.architecture.fragment.BaseFragment
import com.bambinifashion.designers.databinding.DesignersFragmentBinding

class DesignersFragment: BaseFragment<DesignersFragmentBinding>(
    R.layout.designers_fragment
) {
    override fun getBindingLayout(v: View): DesignersFragmentBinding {
        return DesignersFragmentBinding.bind(v)
    }


}
