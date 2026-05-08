package com.example.tatiana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.tatiana.ui.navigations.AppNavigation
import com.example.tatiana.ui.theme.FlavorlyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlavorlyTheme {
                AppNavigation()
            }
        }
    }
}
