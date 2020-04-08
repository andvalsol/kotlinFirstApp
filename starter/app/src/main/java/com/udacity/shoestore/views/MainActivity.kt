package com.udacity.shoestore.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.ShoeViewModelFactory
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: ShoeViewModel
    private lateinit var viewModelFactory: ShoeViewModelFactory

    private var menuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModelFactory = ShoeViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ShoeViewModel::class.java)

        val navController = findNavController(R.id.main_fragment)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.label != "ShoeList") hideMenu()
            else showMenu()
        }

        setSupportActionBar(binding.toolbar)

        binding.toolbar.setupWithNavController(navController, AppBarConfiguration(navController.graph))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)

        menuItem = menu!!.getItem(0)
        menuItem?.isVisible = false // Set not visible at first

        return true
    }

    private fun hideMenu() {
        menuItem?.isVisible = false
    }

    private fun showMenu() {
        menuItem?.isVisible = true
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.main_fragment).navigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController(R.id.main_fragment))
                || super.onOptionsItemSelected(item)
    }
}
