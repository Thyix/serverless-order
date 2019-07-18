package com.heroesAndVillains.backend.domain.hero

import com.heroesAndVillains.backend.domain.ComicUniverse

data class Robot(
    override val id: Long,
    override val name: String,
    override val universe: ComicUniverse,
    val superPower: String
): Hero