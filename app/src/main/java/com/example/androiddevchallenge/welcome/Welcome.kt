/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

@Composable
fun Welcome() {
    Surface(color = MaterialTheme.colors.primary) {
        Box(modifier = Modifier.fillMaxSize()) {
            Background()
            LogoAndActions()
        }
    }
}

@Composable
private fun LogoAndActions() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier.fillMaxHeight(.5f),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = if (MaterialTheme.colors.isLight) R.drawable.light_logo else R.drawable.dark_logo),
                    contentDescription = null
                )
                Text(
                    text = "Beautiful home garden solutions",
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.secondary,
                    modifier = Modifier.paddingFromBaseline(top = 32.dp)
                )
                LoginButton(modifier = Modifier.padding(top = 40.dp))
                TextButton(modifier = Modifier.padding(top = 24.dp), onClick = { }) {
                    Text(text = "Log in", color = MaterialTheme.colors.secondary)
                }
            }
        }
    }
}

@Composable
fun LoginButton(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Button(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .height(48.dp),
            shape = MaterialTheme.shapes.medium,
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = MaterialTheme.colors.onSecondary
            )
        ) {
            Text(text = "Create account")
        }
    }
}

@Composable
private fun Background() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .scale(scaleX = 1.1f, scaleY = 1.3f),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = if (MaterialTheme.colors.isLight) R.drawable.light_welcome_bg else R.drawable.dark_welcome_bg),
            contentDescription = null
        )
    }
    Box(
        modifier = Modifier
            .fillMaxHeight(.6f)
            .fillMaxWidth()
            .offset(x = 32.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Image(
            painter = painterResource(id = if (MaterialTheme.colors.isLight) R.drawable.light_welcome_illos else R.drawable.dark_welcome_illos),
            contentDescription = null,
        )
    }
}
