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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.GlideImage
import com.pp.bloom.domain.models.HomeGarden
import com.pp.bloom.ui.theme.CardElevation

@Composable
fun BloomCardRow(homeGardens: List<HomeGarden>) {
    Text(
        text = "Browse themes",
        modifier = Modifier
            .paddingFromBaseline(top = 32.dp)
            .padding(start = 16.dp),
        style = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.onBackground
    )
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 16.dp, start = 16.dp)
    ) {
        items(homeGardens) { homeGarden ->
            BloomCardRowItem(homeGarden)
        }
    }
}

@Composable
private fun BloomCardRowItem(homeGarden: HomeGarden) {
    val cardShape = MaterialTheme.shapes.small.copy(
        bottomStart = CornerSize(0.dp),
        bottomEnd = CornerSize(0.dp)
    )

    Box(
        modifier = Modifier
            .size(138.dp)
            .padding(2.dp)
            .shadow(CardElevation, shape = cardShape)
    ) {
        Card(
            elevation = 0.dp,
            modifier = Modifier.size(136.dp),
            shape = MaterialTheme.shapes.small,
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                GlideImage(
                    data = homeGarden.imageRes,
                    contentDescription = homeGarden.name,
                    fadeIn = true,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxHeight(.7f)
                        .fillMaxWidth()
                )
                Text(
                    text = homeGarden.name,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.padding(top = 8.dp, start = 8.dp)
                )
            }
        }
    }
}
