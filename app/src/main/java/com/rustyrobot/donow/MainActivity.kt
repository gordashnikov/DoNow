package com.rustyrobot.donow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rustyrobot.donow.data.navigation.SetupNavigation
import com.rustyrobot.donow.ui.theme.DoNowTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoNowTheme {
                navController = rememberNavController()
                SetupNavigation(navController = navController)


            }
        }
    }
}

