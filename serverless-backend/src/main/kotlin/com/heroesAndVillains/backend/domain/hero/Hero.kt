package com.heroesAndVillains.backend.domain.hero

import com.heroesAndVillains.backend.domain.ComicUniverse

interface Hero {
    val id: String
    val name: String
    val universe: ComicUniverse
}