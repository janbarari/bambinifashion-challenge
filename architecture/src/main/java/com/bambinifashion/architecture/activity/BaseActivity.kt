package com.bambinifashion.architecture.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>(
    @LayoutRes private val layoutId: Int
): AppCompatActivity() {

    abstract fun getLayoutBinding(v: View): VB
    private var _binding: VB? = null

    fun getBinding(): VB {
        return _binding!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onActivityCreate(savedInstanceState, intent)
        _binding = getLayoutBinding(LayoutInflater.from(this).inflate(layoutId, null))
        setContentView(_binding!!.root)
        setupViews()
        setupObservers()
        setupListeners()
        onActivityCreated()
    }

    open fun onActivityCreate(savedInstanceState: Bundle?, intent: Intent) {}
    open fun setupViews() {}
    open fun setupObservers() {}
    open fun setupListeners() {}
    open fun onActivityCreated() {}

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}