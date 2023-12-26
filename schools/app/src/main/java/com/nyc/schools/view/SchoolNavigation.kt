package com.nyc.schools.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nyc.schools.R


/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolAppBar(
    currentScreen: Screens,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(currentScreen.screen) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            } else {
                IconButton(onClick = navigateUp) {
                    Icon(
                        painter = painterResource(id = R.drawable.school),
                        contentDescription = "School"
                    )
                }
            }
        }
    )
}

/**
 * Starting composable which handles the app navigation to the School list and Detail screens.
 */
@Composable
fun SchoolApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Screens.valueOf(
        backStackEntry?.destination?.route?.substringBefore("/") ?: Screens.Schools.name
    )

    Scaffold(
        topBar = {
            SchoolAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screens.Schools.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Screens.Schools.name) {
                SchoolScreen(
                    onSelectionChanged = { dbn ->
                        navController.navigate("${Screens.Detail.name}/$dbn")
                    }
                )
            }
            composable(
                route = "${Screens.Detail.name}/{dbn}",
                arguments = listOf(navArgument("dbn") {
                    type = NavType.StringType
                })
            ) {
                SchoolDetailScreen(
                    backStackEntry?.arguments?.getString("dbn") ?: "",
                )
            }

        }
    }
}