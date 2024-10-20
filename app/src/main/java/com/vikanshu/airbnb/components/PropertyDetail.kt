package com.vikanshu.airbnb.components

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.vikanshu.airbnb.R

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.PropertyDetail(
    modifier: Modifier = Modifier,
    index: Int,
    navController: NavController,
    animatedVisibilityScope: AnimatedVisibilityScope
) {

    val pagerState = rememberPagerState {
        images.size
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .sharedElement(
                state = rememberSharedContentState(key = "card_$index"),
                animatedVisibilityScope = animatedVisibilityScope
            )
    ) {
        Box(
            modifier = Modifier
        ) {
            HorizontalPager(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                state = pagerState
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize(),
                    model = images[it],
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .safeDrawingPadding()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    navController.popBackStack()
                }, colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {
                    navController.popBackStack()
                }, colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = null)
                }
            }
            PagerDots(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp),
                pagerState = pagerState,
                totalPages = images.size
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Jibhi, India", fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.weight(1f))
            AsyncImage(
                model = "https://upload.wikimedia.org/wikipedia/commons/7/78/BlackStar.PNG",
                contentDescription = "",
                modifier = Modifier.size(10.dp)
            )
            Text(modifier = Modifier.padding(start = 8.dp), text = "4.89", fontSize = 12.sp)
        }
        Text(text = "Individual Host", fontSize = 12.sp, color = Color.Gray, lineHeight = 18.sp, modifier = Modifier.padding(horizontal = 16.dp))
        Text(text = "5 nights", fontSize = 12.sp, color = Color.Gray, lineHeight = 18.sp, modifier = Modifier.padding(horizontal = 16.dp))
        Text(
            modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp),
            text = AnnotatedString.Builder().apply {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("₹ 5000")
                }
                append(" total before taxes")
            }.toAnnotatedString(),
            textDecoration = TextDecoration.Underline
        )
    }
}