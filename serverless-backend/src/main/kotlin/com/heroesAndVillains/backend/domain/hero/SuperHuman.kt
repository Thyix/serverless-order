package com.heroesAndVillains.backend.domain.hero

import com.heroesAndVillains.backend.domain.ComicUniverse

data class SuperHuman(
    override val id: String,
    override val name:String,
    override val universe: ComicUniverse,
    val realName: String,
    val superPower: String
): Hero