package com.vikanshu.airbnb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.vikanshu.airbnb.components.PropertyDetail
import com.vikanshu.airbnb.components.PropertyListing
import com.vikanshu.airbnb.components.PropertyListingCard
import com.vikanshu.airbnb.components.Tabs
import com.vikanshu.airbnb.components.images
import com.vikanshu.airbnb.components.tabs
import com.vikanshu.airbnb.ui.theme.AirbnbTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalSharedTransitionApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            AirbnbTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SharedTransitionLayout(
                        modifier = Modifier
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = "listing",
                            enterTransition = { NavigationAnimations.ENTER_SLIDE_IN_BOTTOM },
                            exitTransition = { NavigationAnimations.EXIT_FADE_OUT },
                            popExitTransition = { NavigationAnimations.EXIT_SLIDE_OUT_BOTTOM },
                            popEnterTransition = { NavigationAnimations.ENTER_FADE_IN }
                        ) {
                            composable(route = "listing") {
                                PropertyListing(
                                    navController = navController,
                                    animatedVisibilityScope = this
                                )
                            }
                            composable("detail/{id}") { navBackStackEntry ->

                                val id =
                                    navBackStackEntry.arguments?.getString("id")?.toIntOrNull() ?: 0

                                PropertyDetail(
                                    animatedVisibilityScope = this,
                                    index = id,
                                    navController = navController
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}