package com.bambinifashion.architecture.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding>(
    @LayoutRes private val layoutId: Int
): Fragment() {

    abstract fun getBindingLayout(v: View): VB
    private var _binding: VB? = null

    fun getBinding(): VB {
        return _binding!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onFragmentCreate(savedInstanceState, arguments)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getBindingLayout(
            LayoutInflater.from(requireContext()).inflate(layoutId, container, false)
        )
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservers()
        setupListeners()
        onFragmentCreated()
    }

    open fun onFragmentCreate(savedInstanceState: Bundle?, arguments: Bundle?){}
    open fun setupViews(){}
    open fun setupObservers(){}
    open fun setupListeners(){}
    open fun onFragmentCreated(){}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
