package com.vikanshu.airbnb.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import coil3.compose.AsyncImage
import com.vikanshu.airbnb.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val tabs = listOf(
    TabItem("https://cdn-icons-png.flaticon.com/512/157/157839.png", "Amazing Pools"),
    TabItem("https://cdn-icons-png.freepik.com/512/140/140780.png", "Cabins"),
    TabItem("https://cdn-icons-png.flaticon.com/512/3337/3337898.png", "Countryside"),
    TabItem("https://cdn-icons-png.freepik.com/512/36/36366.png", "Treehouse"),
    TabItem("https://cdn-icons-png.flaticon.com/512/3337/3337898.png", "Luxe"),
    TabItem("https://cdn-icons-png.flaticon.com/512/157/157839.png", "Amazing Pools"),
    TabItem("https://cdn-icons-png.freepik.com/512/140/140780.png", "Cabins"),
    TabItem("https://cdn-icons-png.flaticon.com/512/3337/3337898.png", "Countryside"),
    TabItem("https://cdn-icons-png.freepik.com/512/36/36366.png", "Treehouse"),
    TabItem("https://cdn-icons-png.flaticon.com/512/3337/3337898.png", "Luxe"),
    TabItem("https://cdn-icons-png.flaticon.com/512/157/157839.png", "Amazing Pools"),
    TabItem("https://cdn-icons-png.freepik.com/512/140/140780.png", "Cabins"),
    TabItem("https://cdn-icons-png.flaticon.com/512/3337/3337898.png", "Countryside"),
    TabItem("https://cdn-icons-png.freepik.com/512/36/36366.png", "Treehouse"),
    TabItem("https://cdn-icons-png.flaticon.com/512/3337/3337898.png", "Luxe"),
    TabItem("https://cdn-icons-png.flaticon.com/512/157/157839.png", "Amazing Pools"),
    TabItem("https://cdn-icons-png.freepik.com/512/140/140780.png", "Cabins"),
    TabItem("https://cdn-icons-png.flaticon.com/512/3337/3337898.png", "Countryside"),
    TabItem("https://cdn-icons-png.freepik.com/512/36/36366.png", "Treehouse"),
    TabItem("https://cdn-icons-png.flaticon.com/512/3337/3337898.png", "Luxe"),
)

val images =
    listOf(
        "https://a0.muscache.com/im/pictures/ebb6a254-f086-4e17-acd2-54a78517c7e2.jpg?im_w=720",
        "https://a0.muscache.com/im/pictures/82734f28-00ec-44fe-8f4c-fefd122b870e.jpg?im_w=720",
        "https://a0.muscache.com/im/ml/photo_enhancement/pictures/miso/Hosting-45458574/original/5538ed75-873d-46fd-a81a-258cf1a16d43.jpeg?im_w=720",
        "https://a0.muscache.com/im/pictures/miso/Hosting-45458574/original/c6b278ed-9d8e-413c-b991-91c337d96e94.jpeg",
        "https://a0.muscache.com/im/pictures/miso/Hosting-49890777/original/d51cfc32-f27e-4632-9390-39e59edd4fa0.jpeg?im_w=720",
        "https://a0.muscache.com/im/pictures/miso/Hosting-48928829/original/10240156-6c65-4eca-a61e-42bff0e94a01.jpeg?im_w=720",
        "https://a0.muscache.com/im/pictures/7949b4f3-e1fa-4b6a-ba13-0d6fb0d82baa.jpg?im_w=720"
    )

@Composable
fun PropertyListingCard(
    modifier: Modifier = Modifier
) {

    val pagerState = rememberPagerState {
        images.size
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier) {
            HorizontalPager(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .clip(RoundedCornerShape(12.dp)),
                state = pagerState
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = images[it],
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Image(
                modifier = Modifier
                    .padding(top = 16.dp, end = 16.dp)
                    .size(20.dp)
                    .align(Alignment.TopEnd),
                painter = painterResource(id = R.drawable.heart),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.White)
            )
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
                .padding(top = 10.dp),
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
        Text(text = "Individual Host", fontSize = 12.sp, color = Color.Gray, lineHeight = 18.sp)
        Text(text = "5 nights", fontSize = 12.sp, color = Color.Gray, lineHeight = 18.sp)
        Text(
            modifier = Modifier.padding(top = 8.dp),
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

data class TabItem(
    val iconUrl: String,
    val title: String
)

class LayoutInfo(
    val width: Int,
    val x: Float
)

@Composable
fun Tabs(
    modifier: Modifier = Modifier,
    items: List<TabItem>
) {

    var selectedItemWidth by remember { mutableStateOf(LayoutInfo(0, 0f)) }

    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyRow(
            state = listState,
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(items) { index, item ->

                var itemSize: LayoutCoordinates? by remember { mutableStateOf(null) }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            coroutineScope.launch {
                                listState.animateScrollToItem(index)
                                selectedItemWidth = LayoutInfo(itemSize?.size?.width ?: 0, itemSize?.positionInParent()?.x ?: 0f)
                            }
                        }
                        .onGloballyPositioned { coordinates ->
                            itemSize = coordinates
                        }
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
                        color = Color.Black
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .width(with(LocalDensity.current) { selectedItemWidth.width.toDp() })
                .height(2.dp)
                .offset { IntOffset(x = selectedItemWidth.x.toInt(), y = 0) }
                .background(Color.Black, shape = RoundedCornerShape(100.dp))
                .animateContentSize()
        )
    }
}