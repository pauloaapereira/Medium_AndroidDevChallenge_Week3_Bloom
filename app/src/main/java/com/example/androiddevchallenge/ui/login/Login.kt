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
package com.example.androiddevchallenge.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.components.BloomLoginButton
import com.example.androiddevchallenge.ui.components.BloomTextInput

@ExperimentalComposeUiApi
@Composable
fun Login(onLoginClick: () -> Unit = {}) {
    Surface(color = MaterialTheme.colors.background) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Log in with email",
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.h1
                )
                BloomTextInput(
                    modifier = Modifier.padding(top = 16.dp),
                    label = "Email address",
                    keyboardType = KeyboardType.Text
                )
                BloomTextInput(
                    modifier = Modifier.padding(top = 8.dp),
                    label = "Password (8+ characters",
                    keyboardType = KeyboardType.Password
                )
                Text(
                    text = getTermsAndPrivacyPolicy(),
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.paddingFromBaseline(top = 24.dp)
                )
                BloomLoginButton(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "Log in",
                    onClick = onLoginClick
                )
            }
        }
    }
}

private fun getTermsAndPrivacyPolicy() =
    buildAnnotatedString {
        append("By clicking below, you agree to our ")
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append("Terms of Use")
        }
        append(" and consent to our ")
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append("Privacy Policy")
        }
        append(".")
    }
