package com.vikanshu.airbnb.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import kotlinx.coroutines.launch

data class TabItem(
    val iconUrl: String,
    val title: String
)

@Composable
fun Tabs(
    modifier: Modifier = Modifier,
    items: List<TabItem>
) {

    var selectedItem by remember { mutableIntStateOf(0) }

    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LazyRow(
        state = listState,
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(items) { index, item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable {
                        selectedItem = index
                        coroutineScope.launch { listState.animateScrollToItem(index) }
                    }
                    .width(IntrinsicSize.Max)
            ) {
                AsyncImage(
                    model = item.iconUrl,
                    contentDescription = item.title,
                    modifier = Modifier.size(30.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = item.title,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .height(2.dp)
                        .fillMaxWidth()
                        .background(
                            if (selectedItem == index) Color.Black else Color.Transparent,
                            shape = RoundedCornerShape(100.dp)
                        )

                )
            }
        }
    }
}