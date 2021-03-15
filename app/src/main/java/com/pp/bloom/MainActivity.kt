/*
 * Copyright 2021 Paulo Pereira
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
package com.pp.bloom

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.pp.bloom.data.HomeGardenRepository
import com.pp.bloom.ui.HomeGardenViewModel
import com.pp.bloom.ui.HomeGardenViewModelFactory
import com.pp.bloom.ui.home.Home
import com.pp.bloom.ui.login.Login
import com.pp.bloom.ui.theme.BloomTheme
import com.pp.bloom.ui.welcome.Welcome

class MainActivity : AppCompatActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BloomTheme {
                Bloom()
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun Bloom() {
    val navController = rememberNavController()
    val viewModel = viewModel(
        HomeGardenViewModel::class.java,
        factory = HomeGardenViewModelFactory(HomeGardenRepository())
    )

    NavHost(navController, startDestination = "welcome") {
        composable("welcome") {
            Welcome(
                onLoginClick = {
                    navController.navigate("login")
                }
            )
        }
        composable("login") {
            Login(
                onLoginClick = {
                    navController.navigate("home")
                }
            )
        }
        composable("home") { Home(viewModel) }
    }
}

@ExperimentalComposeUiApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    BloomTheme {
        Bloom()
    }
}

@ExperimentalComposeUiApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    BloomTheme(darkTheme = true) {
        Bloom()
    }
}
