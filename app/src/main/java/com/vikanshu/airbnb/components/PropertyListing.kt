package com.vikanshu.airbnb.components

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.PropertyListing(
    modifier: Modifier = Modifier,
    navController: NavController,
    animatedVisibilityScope: AnimatedVisibilityScope
) {

    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier.safeDrawingPadding()
    ) {
        Tabs(modifier = Modifier.fillMaxWidth(), items = tabs)
        HorizontalDivider()
        LazyColumn(
            state = lazyListState,
            modifier = Modifier.fillMaxSize(),
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            items(10, key = {
                "card_item_$it"
            }) {
                PropertyListingCard(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .clickable {
                            coroutineScope.launch {
                                navController.navigate("detail/$it")
                            }
                        },
                    animatedVisibilityScope = animatedVisibilityScope,
                    index = it
                )
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}