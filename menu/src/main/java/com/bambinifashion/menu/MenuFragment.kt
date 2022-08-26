package com.bambinifashion.menu

import android.view.View
import com.bambinifashion.architecture.fragment.BaseFragment
import com.bambinifashion.menu.databinding.MenuFragmentBinding

class MenuFragment: BaseFragment<MenuFragmentBinding>(
    R.layout.menu_fragment
) {
    override fun getBindingLayout(v: View): MenuFragmentBinding {
        return MenuFragmentBinding.bind(v)
    }


}
