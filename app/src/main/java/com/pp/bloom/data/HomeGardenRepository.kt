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
package com.pp.bloom.data

import com.pp.bloom.R
import com.pp.bloom.domain.models.HomeGarden
import kotlinx.coroutines.flow.flowOf

class HomeGardenRepository : IHomeGardenRepository {

    override fun getHomeGardenList() = flowOf(
        listOf(
            HomeGarden(
                name = "Desert chic",
                imageRes = R.drawable.desert_chic
            ),
            HomeGarden(
                name = "Tiny terrariums",
                imageRes = R.drawable.tiny_terrariums
            ),
            HomeGarden(
                name = "Jungle vibes",
                imageRes = R.drawable.jungle_vibes
            ),
            HomeGarden(
                name = "Easy care",
                imageRes = R.drawable.easy_care
            ),
            HomeGarden(
                name = "Statements",
                imageRes = R.drawable.statements
            ),
            HomeGarden(
                name = "Monstera",
                imageRes = R.drawable.monstera
            ),
            HomeGarden(
                name = "Aglaonema",
                imageRes = R.drawable.aglaonema
            ),
            HomeGarden(
                name = "Peace lily",
                imageRes = R.drawable.peace_lily
            ),
            HomeGarden(
                name = "Fiddle leaf",
                imageRes = R.drawable.fiddle_leaf
            ),
            HomeGarden(
                name = "Snake plant",
                imageRes = R.drawable.snake_plant
            ),
            HomeGarden(
                name = "Pothos",
                imageRes = R.drawable.photos
            ),
        )
    )
}
