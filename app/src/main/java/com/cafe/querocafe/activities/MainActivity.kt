package com.cafe.querocafe.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cafe.querocafe.R
import com.cafe.querocafe.adapters.PurchasesAdapter
import com.cafe.querocafe.databinding.ActivityMainBinding
import com.cafe.querocafe.model.view.PurchasesViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import javax.inject.Inject
import androidx.lifecycle.Observer
import com.cafe.querocafe.extensions.dataBindView
import com.cafe.querocafe.extensions.getViewModel
import com.cafe.querocafe.extensions.ioc

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var _model: PurchasesViewModel
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ioc.inject(this)
        _model = getViewModel(viewModelFactory)
        _binding = dataBindView(R.layout.activity_main)
        _binding.model = _model

        setSupportActionBar(_binding.appBarMain.toolbar)
        setupDrawer()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val adapter = PurchasesAdapter(emptyList(), View.OnClickListener {  })
        val recyclerView = _binding.appBarMain.contentMain.purchasesRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        _binding.executePendingBindings()
        _model.purchases.observe(this, Observer { it?.let(adapter::setData) })
        _model.getPurchases()
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
