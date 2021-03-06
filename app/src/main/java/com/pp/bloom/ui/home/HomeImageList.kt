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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.GlideImage
import com.pp.bloom.R
import com.pp.bloom.domain.models.HomeGarden

@Composable
fun BloomImageList(homeGardens: List<HomeGarden>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, start = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Design your home garden",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground
        )
        Icon(
            modifier = Modifier.padding(end = 16.dp),
            painter = painterResource(id = R.drawable.filter_list),
            contentDescription = "Filter"
        )
    }
    Column(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 56.dp)) {
        homeGardens.forEachIndexed { index, homeGarden ->
            BloomImageListItem(isSelected = index == 0, homeGarden = homeGarden)
            Spacer(Modifier.size(8.dp))
        }
    }
}

@Composable
private fun BloomImageListItem(homeGarden: HomeGarden, isSelected: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        GlideImage(
            data = homeGarden.imageRes,
            contentDescription = homeGarden.name,
            fadeIn = true,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(MaterialTheme.shapes.small)
        )
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = homeGarden.name, style = MaterialTheme.typography.h2)
                    Text(text = "This is a description", style = MaterialTheme.typography.body1)
                }
                Checkbox(
                    checked = isSelected,
                    onCheckedChange = {},
                    colors = CheckboxDefaults.colors(checkmarkColor = MaterialTheme.colors.background)
                )
            }
            Divider()
        }
    }
}
