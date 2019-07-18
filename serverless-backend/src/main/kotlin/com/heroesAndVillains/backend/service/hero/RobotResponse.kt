package com.heroesAndVillains.backend.service.hero

data class RobotResponse(
    override val id: Long,
    override val name: String,
    override val universe: String,
    override val type: String,
    val superPower: String
): HeroResponse