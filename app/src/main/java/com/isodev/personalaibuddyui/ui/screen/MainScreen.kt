package com.isodev.personalaibuddyui.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.isodev.personalaibuddyui.R
import com.isodev.personalaibuddyui.ui.theme.ColorBlack2
import com.isodev.personalaibuddyui.util.GlowingImage

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier
            .fillMaxSize()
            .background(color = ColorBlack2)
    ) {
        Image(
            painter = painterResource(R.drawable.background_design_1),
            contentDescription = null,
            modifier = Modifier
                .size(909.dp, 697.dp)
                .align(Alignment.Center)
                .offset(y = (-100).dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Image(
                painter = painterResource(R.drawable.background_personel_buddy),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 28.dp)
                    .size(173.dp, 39.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))
            GlowingImage(modifier = modifier.size(420.dp))
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                painter = painterResource(R.drawable.text_warning_help),
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