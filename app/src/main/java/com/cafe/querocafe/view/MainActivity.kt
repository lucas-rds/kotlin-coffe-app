package com.cafe.querocafe.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cafe.querocafe.App
import com.cafe.querocafe.R
import com.cafe.querocafe.databinding.ActivityMainBinding
import com.cafe.querocafe.extensions.view.snackbar
import com.cafe.querocafe.model.Person
import com.cafe.querocafe.view.model.PurchasesViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var _binding: ActivityMainBinding

    @Inject
    lateinit var lucas: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).component.inject(this)
        val model = ViewModelProviders.of(this).get(PurchasesViewModel::class.java)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        _binding.model = model

        setSupportActionBar(_binding.appBarMain.toolbar)

        fab.setOnClickListener {
            it.snackbar("Xablau")
                .setAction("Action") { view -> println(view.alpha) }
                .show()
        }

        setupDrawer()

        println(lucas.name)
    }

    private fun setupDrawer() {
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_camera -> {
            }
            R.id.nav_gallery -> {
            }
            R.id.nav_slideshow -> {
            }
            R.id.nav_manage -> {
            }
            R.id.nav_share -> {
            }
            R.id.nav_send -> {
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
