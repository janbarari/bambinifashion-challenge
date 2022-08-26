package com.bambinifashion.search

import android.view.View
import com.bambinifashion.architecture.fragment.BaseFragment
import com.bambinifashion.search.databinding.SearchFragmentBinding

class SearchFragment: BaseFragment<SearchFragmentBinding>(
    R.layout.search_fragment
) {
    override fun getBindingLayout(v: View): SearchFragmentBinding {
        return SearchFragmentBinding.bind(v)
    }


}
