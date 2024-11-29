package com.isodev.personalaibuddyui

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.isodev.personalaibuddyui.ui.theme.PersonalAiBuddyUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PersonalAiBuddyUiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Navigation(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Navigation(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable("main") { backStackEntry ->
            MainScreen(modifier = modifier, onClick = { navController.navigate("second") })
        }
        composable("second") { backStackEntry ->
            SecondScreen(modifier = modifier)
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier, onClick: () -> Unit) {
    HideSystemBars()
    Box(
        modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.black2))
    ) {
        Image(
            painter = painterResource(R.drawable.group_1__2_),
            contentDescription = null,
            modifier = Modifier
                .size(909.dp, 697.dp)
                .align(Alignment.Center)
                .offset(y = -100.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Image(
                painter = painterResource(R.drawable.frame_1),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 28.dp)
                    .size(173.dp, 39.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))
            GlowingImage(modifier = modifier.size(420.dp))
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                painter = painterResource(R.drawable.how_may___help_you_today___1_),
                contentDescription = null,
                Modifier.padding(bottom = 32.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ), modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .height(66.dp)
            ) {
                Text(text = "Get Started")
            }
        }
    }
}


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
        progress = progress,
        modifier = modifier.size(size)
    )
}

@Composable
fun SecondScreen(modifier: Modifier = Modifier) {
    var isPressed by remember { mutableStateOf(false) }
    var speed by remember { mutableStateOf(1f) }
    HideSystemBars()
    Box(
        modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.black2))
            .windowInsetsPadding(WindowInsets.systemBars)
    ) {
        Image(
            painter = painterResource(R.drawable.group_1__3_),
            contentDescription = null,
            modifier = Modifier
                .size(909.dp, 697.dp)
                .align(Alignment.TopEnd)
                .offset(y = -260.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(R.drawable.ai_buddy),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 28.dp)
                    .size(92.dp, 34.dp)
            )
            Image(
                painter = painterResource(R.drawable.frame_15),
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
                Image(painter = painterResource(R.drawable.group_3), contentDescription = "")
            }
        }
    }

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

@Composable
fun HideSystemBars() {
    val context = LocalContext.current
    if (context is ComponentActivity) {
        val window = context.window
        WindowCompat.setDecorFitsSystemWindows(
            window,
            false
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.apply {
                hide(android.view.WindowInsets.Type.systemBars())
                systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    )
        }
    }
}