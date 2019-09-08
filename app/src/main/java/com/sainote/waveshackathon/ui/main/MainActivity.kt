package com.sainote.waveshackathon.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.setupWithNavController
import com.sainote.waveshackathon.R
import com.sainote.waveshackathon.databinding.ActivityMainBinding
import com.sainote.waveshackathon.ui.base.activity.BaseActivity
import com.sainote.waveshackathon.util.extentions.setupWithNavController
import dagger.Lazy
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(R.layout.activity_main) {

    @Inject
    override lateinit var binding: Lazy<ActivityMainBinding>

    @Inject
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) setupBottomNavigationBar()
        }

    private fun setupBottomNavigationBar() {

        val navGraphIds = listOf(
            R.navigation.news,
            R.navigation.categories,
            R.navigation.question,
            R.navigation.profile
        )

        // Setup the bottom navigation view with a list of navigation graphs
        bottom_nav.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

    }
}
