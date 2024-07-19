package uz.androbeck.virtualbank.ui.main_activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.androbeck.virtualbank.R
import uz.androbeck.virtualbank.databinding.ActivityMainBinding
import uz.androbeck.virtualbank.extentions.gone
import uz.androbeck.virtualbank.extentions.visible

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {
    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainViewModel>()
    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment).navController
    }
    private val navHost by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener(this)
        viewModel.checkRegistration()
        starNavGraph()



    }

    fun starNavGraph() {
        viewModel.getMainEvent.observe(this) {
            when (it) {
                GetMainEvent.Loading -> {

                }
                is GetMainEvent.NotRegistered -> {
//                    navController.popBackStack(navController.graph.startDestinationId, false)
//                    navController.setGraph(R.navigation.registration_nav_graph)
                    navHost.navController.graph =
                        navHost.navController.navInflater.inflate(R.navigation.registration_nav_graph)
                }

                is GetMainEvent.Success -> {

                    /*navController.popBackStack(navController.graph.startDestinationId, false)
                    navController.setGraph(R.navigation.nav_graph)*/
                    navHost.navController.graph =
                        navHost.navController.navInflater.inflate(R.navigation.nav_graph)
                }
            }
        }
    }

    override fun onDestinationChanged(
        controller: NavController, destination: NavDestination, arguments: Bundle?
    ) = with(binding) {
        when (destination.id) {
            R.id.navigation_home, R.id.navigation_payments, R.id.navigation_report -> {
                navView.visible()
            }

            else -> {
                navView.gone()
            }
        }
    }

}