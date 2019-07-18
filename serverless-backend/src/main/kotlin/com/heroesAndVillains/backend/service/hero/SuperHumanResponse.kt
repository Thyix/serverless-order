package com.heroesAndVillains.backend.service.hero

class SuperHumanResponse (
    override val id: Long,
    override val name: String,
    override val universe: String,
    override val type: String,
    val superPower: String,
    val realName: String
): HeroResponse