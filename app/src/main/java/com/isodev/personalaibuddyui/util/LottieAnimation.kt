package com.isodev.personalaibuddyui.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.isodev.personalaibuddyui.R

@Composable
fun LottieAnimation(modifier: Modifier = Modifier, resId: Int, size: Dp, speed: Float = 1f) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(resId))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        speed = speed
    )

    LottieAnimation(
        composition = composition,
        progress = {
            progress
        },
        modifier = modifier.size(size)
    )
}

@Composable
fun GlowingImage(modifier: Modifier) {
    Box(
        modifier = modifier
            .size(400.dp, 300.dp)
            .graphicsLayer {
                shadowElevation = 20f
                shape = CircleShape
                clip = true
            }
            .background(
                Brush.radialGradient(
                    colors = listOf(
                        Color(0x66FFFF00),
                        Color(0x00FFFF00)
                    ),
                    center = Offset.Unspecified
                )
            )
    ) {
        LottieAnimation(resId = R.raw.bot, size = 600.dp)
    }
}