package com.heroesAndVillains.backend.service.hero

import com.heroesAndVillains.backend.domain.ComicUniverse

class HumanResponse (
    override val id: String,
    override val name: String,
    override val universe: ComicUniverse,
    override val type: String,
    val realName: String
): HeroResponse