package com.iamacat.navigation.navigation

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.iamacat.navigation.composition.LocalActivity
import com.iamacat.navigation.composition.LocalNavController
import com.iamacat.navigation.composition.LocalSnackBarHostState
import com.iamacat.navigation.host.AppNavHost
import com.iamacat.navigation.route.ScreenRoute


@Composable
fun AppNavigation(
    navController: NavHostController,
    snackBarHostState: SnackbarHostState,
    initialRoute: ScreenRoute
) {
    val context = LocalContext.current
    val activity = context.findActivity()

    Scaffold(
        contentWindowInsets = WindowInsets(0),
        snackbarHost = {
            SnackbarHost(
                hostState = snackBarHostState,
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .windowInsetsPadding(WindowInsets.ime.add(WindowInsets.navigationBars))
            ) {
                Snackbar(snackbarData = it)
            }
        },
    ) { paddingValues ->
        if (activity != null) {
            CompositionLocalProvider(
                LocalSnackBarHostState provides snackBarHostState,
                LocalNavController provides navController,
                LocalActivity provides activity
            ) {
                AppNavHost(
                    modifier = Modifier.padding(paddingValues),
                    navController = navController,
                    initialRoute = initialRoute
                )
            }
        }
    }
}

private fun Context.findActivity(): Activity? {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    return null
}
