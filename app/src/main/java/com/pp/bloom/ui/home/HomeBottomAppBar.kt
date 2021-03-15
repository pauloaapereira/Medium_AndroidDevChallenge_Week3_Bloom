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
package com.pp.bloom.ui.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pp.bloom.R
import com.pp.bloom.ui.theme.BottomNavigationElevation

@Composable
fun BloomBottomBar() {
    BottomAppBar(
        elevation = BottomNavigationElevation,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BloomBottomBarItem(isSelected = true, text = "Home", icon = R.drawable.home)
            BloomBottomBarItem(text = "Favorites", icon = R.drawable.favorite_border)
            BloomBottomBarItem(text = "Profile", icon = R.drawable.account_circle)
            BloomBottomBarItem(text = "Cart", icon = R.drawable.shopping_cart)
        }
    }
}

@Composable
private fun BloomBottomBarItem(isSelected: Boolean = false, text: String, @DrawableRes icon: Int) {
    val color =
        if (isSelected) MaterialTheme.colors.onBackground else LocalContentColor.current.copy(alpha = .6f)
    val style = if (isSelected) MaterialTheme.typography.caption else LocalTextStyle.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = text,
            modifier = Modifier.requiredSize(24.dp),
            tint = color
        )
        Text(
            text = text,
            style = style,
            color = color
        )
    }
}
