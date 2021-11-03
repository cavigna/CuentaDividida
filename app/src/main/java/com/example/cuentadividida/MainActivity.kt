package com.example.cuentadividida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.cuentadividida.application.ConsumoApplication
import com.example.cuentadividida.databinding.ActivityMainBinding
import com.example.cuentadividida.viewmodel.ConsumoViewModel
import com.example.cuentadividida.viewmodel.ConsumoViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private val viewModel : ConsumoViewModel by viewModels {
        ConsumoViewModelFactory((application as ConsumoApplication).repository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = navHostFragment.navController

        binding.bottomNav.setOnItemSelectedListener{item->
            when (item.itemId) {
                R.id.menu_agregar ->navController.navigate(R.id.homeFragment)
                R.id.menu_lista -> navController.navigate(R.id.listFragment)

            }
            true
        }
    }
}