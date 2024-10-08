package com.rahim.yadino.routine.homeScreen.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.rahim.yadino.routine.homeScreen.HomeRoute
import com.rahim.yadino.navigation.Destinations

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(Destinations.Home.route, navOptions)
}

fun NavGraphBuilder.homeScreen(openDialog:Boolean,clickSearch: Boolean,onOpenDialog:(isOpen:Boolean)->Unit) {
    composable(Destinations.Home.route) {
        HomeRoute(openDialog = openDialog, clickSearch = clickSearch, onOpenDialog = onOpenDialog)
    }
}