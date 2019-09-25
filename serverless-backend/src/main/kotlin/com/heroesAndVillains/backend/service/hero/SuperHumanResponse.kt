package com.heroesAndVillains.backend.service.hero

import com.heroesAndVillains.backend.domain.ComicUniverse

class SuperHumanResponse (
    override val id: String,
    override val name: String,
    override val universe: ComicUniverse,
    override val type: String,
    val superPower: String,
    val realName: String
): HeroResponse