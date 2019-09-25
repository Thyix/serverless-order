package com.heroesAndVillains.backend.service.hero

import com.heroesAndVillains.backend.domain.ComicUniverse

data class RobotResponse(
    override val id: String,
    override val name: String,
    override val universe: ComicUniverse,
    override val type: String,
    val superPower: String
): HeroResponse