package com.heroesAndVillains.backend.service.hero

class HumanResponse (
    override val id: Long,
    override val name: String,
    override val universe: String,
    override val type: String,
    val realName: String
): HeroResponse