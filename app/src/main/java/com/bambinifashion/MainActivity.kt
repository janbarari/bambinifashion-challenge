package com.bambinifashion

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bambinifashion.architecture.activity.BaseActivity
import com.bambinifashion.databinding.MainActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityBinding>(R.layout.main_activity) {

    override fun getLayoutBinding(v: View): MainActivityBinding {
        return MainActivityBinding.bind(v)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            initBottomNavigation()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        getBinding().bottomMenu.setupWithNavController(
            navGraphIds = listOf(
                R.navigation.menu_navgraph,
                R.navigation.home_navgraph,
                R.navigation.bag_navgraph,
                R.navigation.search_navgraph,
                R.navigation.designers_navgraph,
            ),
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_fragment,
            intent = intent
        )
    }

    override fun setupListeners() {
        getBinding().header.favoriteButton.setOnClickListener {
            Toast.makeText(this, "Not Implemented Yet!", Toast.LENGTH_LONG).show()
        }
    }

}
