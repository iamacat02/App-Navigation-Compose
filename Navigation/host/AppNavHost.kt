package com.iamacat.navigation.host

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.toRoute
import com.iamacat.navigation.route.ScreenRoute
import com.iamacat.navigation.transition.appNavComposable

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    initialRoute: ScreenRoute
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = initialRoute,
    ) {
        appNavComposable<ScreenRoute.Home> {
        }

        appNavComposable<ScreenRoute.Details> { backStackEntry ->
            val route = backStackEntry.toRoute<ScreenRoute.Details>()
             Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Details Screen: ${route.id}")
             }
        }
    }
}
