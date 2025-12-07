package com.iamacat.navigation.route

import kotlinx.serialization.Serializable

@Serializable
sealed class ScreenRoute {
    @Serializable
    object Home : ScreenRoute()
    @Serializable
    data class Details(val id: String) : ScreenRoute()
}
