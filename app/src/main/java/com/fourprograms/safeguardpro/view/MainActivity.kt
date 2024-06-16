package com.fourprograms.safeguardpro.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.fourprograms.safeguardpro.R
import com.fourprograms.safeguardpro.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    private var _binding: MainActivityBinding? = null
    private val binding: MainActivityBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(binding
            .fragmentContainerView.id) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        //binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.bottomNavigation.setupWithNavController(navController)

        setContentView(binding.root)

        navController.addOnDestinationChangedListener { controller, destination, _ ->
            controller.currentDestination?.let {

                if (it.id == R.id.homepageSupervisorFragment) {
                    binding.bottomNavigation.menu.clear()
                    binding.bottomNavigation.inflateMenu(R.menu.bottom_menu)
                } else if (it.id == R.id.homepageFuncionarioFragment) {
                    binding.bottomNavigation.menu.clear()
                    // Caso for exibir outras coisas no menu inferior apenas para funcionario, criar outro menu e chamar na linha abaixo
//                    binding.bottomNavigation.inflateMenu(R.menu.rodape_fun)
                }
            }
        }
    }
}