package com.dan15d.codetest.ui.screens.user_list.shimmer

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ListShimmer() {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),
    )

    val transition = rememberInfiniteTransition(label = "")
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 500,
                easing = FastOutLinearInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )

    ShimmerForDetailScreen(brush = brush)
}

@Composable
fun ShimmerForDetailScreen(brush: Brush) {

    Column(verticalArrangement = Arrangement.Center) {
        ItemShimmer(brush = brush)
        ItemShimmer(brush = brush)
        ItemShimmer(brush = brush)
        ItemShimmer(brush = brush)
        ItemShimmer(brush = brush)
        ItemShimmer(brush = brush)
        ItemShimmer(brush = brush)
        ItemShimmer(brush = brush)
        ItemShimmer(brush = brush)
        ItemShimmer(brush = brush)
    }

}

@Composable
fun ItemShimmer(brush: Brush){
    Spacer(
        modifier = Modifier
            .height(80.dp)
            .padding(start = 16.dp, end = 16.dp)
            .clip(RoundedCornerShape(5.dp))
            .fillMaxWidth()
            .background(brush)
    )

    Spacer(modifier = Modifier.padding(10.dp))

    Spacer(
        modifier = Modifier
            .height(80.dp)
            .padding(start = 16.dp, end = 16.dp)
            .clip(RoundedCornerShape(5.dp))
            .fillMaxWidth()
            .background(brush)
    )
    Spacer(modifier = Modifier.padding(10.dp))
}
