package uz.androbeck.virtualbank.ui.activityMain

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import uz.androbeck.virtualbank.R
import uz.androbeck.virtualbank.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        checking()
        viewModel.uiEvent.observe(this) {
            when (it) {
                MainUiEvent.Checking -> {
                    binding.navView.visibility = View.GONE
                    // it is checking
                }

                is MainUiEvent.Error -> {
                    binding.navView.visibility = View.GONE
                    // it is something error
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }

                MainUiEvent.NotRegistered -> {
                    // it is not registered!
                    binding.navView.visibility = View.GONE

                    val navController = findNavController(R.id.nav_host_fragment)
                    navController.setGraph(R.navigation.login_nav_graph)

                }

                MainUiEvent.Successfully -> {
                    // it is successfully registered!'
                    with(binding) {
                        // navigation graph clear and set new graph
                        val navController = findNavController(R.id.nav_host_fragment)
                        navController.popBackStack(navController.graph.startDestinationId, false)
                            navController.setGraph(R.navigation.nav_graph)

                        navView.visibility = View.VISIBLE


                        setSupportActionBar(toolbar)

                        val navView: BottomNavigationView = navView



                        val appBarConfiguration = AppBarConfiguration(
                            setOf(
                                R.id.fragment_main,
                                R.id.fragment_transfer,
                                R.id.fragment_cards,
                                R.id.fragment_profile
                            )
                        )
                        setupActionBarWithNavController(navController, appBarConfiguration)
                        navView.setupWithNavController(navController)
                    }
                }
            }
        }
    }

    private fun checking() {
        viewModel.checkUserIsRegistered()
    }
}