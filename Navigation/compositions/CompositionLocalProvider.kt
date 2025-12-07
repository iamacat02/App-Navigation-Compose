package com.iamacat.navigation.composition
import android.app.Activity
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.iamacat.navigation.route.ScreenRoute

val LocalNavController =
    staticCompositionLocalOf<NavHostController> { error("NavHostController must be provided") }
val LocalSnackBarHostState =
    staticCompositionLocalOf<SnackbarHostState> { error("SnackBarHostState must be provided") }

val LocalActivity =
    staticCompositionLocalOf<Activity> { error("Activity must be provided") }


// Generic Navigation Composable
inline fun <reified T : ScreenRoute> NavGraphBuilder.appNavComposable(
    noinline content: @Composable (T) -> Unit
) {
    composable<T> { entry: NavBackStackEntry ->
        val route = entry.toRoute<T>()
        content(route)
    }
}
