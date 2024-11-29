package com.isodev.personalaibuddyui.ui.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.isodev.personalaibuddyui.R
import com.isodev.personalaibuddyui.ui.theme.ColorBlack2
import com.isodev.personalaibuddyui.util.LottieAnimation

@Composable
fun SecondScreen() {
    var isPressed by remember { mutableStateOf(false) }
    var speed by remember { mutableFloatStateOf(1f) }
    Box(
        Modifier
            .fillMaxSize()
            .background(color = ColorBlack2)
            .windowInsetsPadding(WindowInsets.systemBars)
    ) {
        Image(
            painter = painterResource(R.drawable.background_design_2),
            contentDescription = null,
            modifier = Modifier
                .size(909.dp, 697.dp)
                .align(Alignment.TopEnd)
                .offset(y = (-260).dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(R.drawable.background_buddy),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 28.dp)
                    .size(92.dp, 34.dp)
            )
            Image(
                painter = painterResource(R.drawable.icon_online),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 28.dp)
                    .size(55.dp, 18.dp)
            )
            LottieAnimation(resId = R.raw.orb, size = 500.dp, speed = speed)
            val waveRadius by animateFloatAsState(
                targetValue = if (isPressed) 1.2f else 1f,
                animationSpec = tween(durationMillis = 1500)
            )
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .scale(waveRadius)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onLongPress = {
                                isPressed = true
                                speed = 2f
                            },
                            onPress = {
                                isPressed = true
                                tryAwaitRelease()
                                isPressed = false
                                speed = 0.5f
                            }
                        )
                    }
            ) {
                Image(
                    painter = painterResource(R.drawable.icon_microphone),
                    contentDescription = ""
                )
            }
        }
    }
}
