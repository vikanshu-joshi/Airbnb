package com.vikanshu.airbnb.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PagerDots(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    totalPages: Int,
    activeColor: Color = Color.White,
    inactiveColor: Color = Color.Gray
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (pageIndex in 0 until totalPages) {
            val isSelected = pagerState.currentPage == pageIndex
            val dotSize by animateFloatAsState(
                targetValue = if (isSelected) 8f else 4f
            )

            Box(
                modifier = Modifier
                    .size(dotSize.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) activeColor else inactiveColor)
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}