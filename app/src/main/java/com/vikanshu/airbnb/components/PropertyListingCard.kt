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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import coil3.compose.AsyncImage
import com.vikanshu.airbnb.R

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

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.PropertyListingCard(
    modifier: Modifier = Modifier,
    index: Int,
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
                    .height(350.dp)
                    .clip(RoundedCornerShape(12.dp)),
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